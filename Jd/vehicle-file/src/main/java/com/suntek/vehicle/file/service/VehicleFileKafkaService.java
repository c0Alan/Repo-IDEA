package com.suntek.vehicle.file.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.suntek.vehicle.file.consts.ProcessStatus;
import com.suntek.vehicle.file.consts.VehicleFileConsts;
import com.suntek.vehicle.file.kafka.consumer.ConsumerFactory;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleFileKafkaService implements IVehicleFileService {

    private static final Logger logger = Logger.getLogger(VehicleFileKafkaService.class);

    @Autowired
    private HashOperations<String, String, Object> hashOperations;

    @Autowired
    private ConsumerFactory consumerFactory;

    @Value("${vehicle-file.maxRecords.perday}")
    private Long maxRecords;

    private ProcessStatus kafkaProcessStatus;

    /**
     * 判断车档信息是否存在
     *
     * @param key : 车牌号-车牌颜色-车辆类型
     * @return
     */
    public boolean isCdxxExisted(String key) {
        return hashOperations.hasKey(VehicleFileConsts.REDIS_HASH_YRK, key);
    }

    /**
     * 新增记录到待入库车档信息中
     *
     * @param key
     * @param value
     */
    public void addToDrkCdxx(String key, String value) {
        hashOperations.put(VehicleFileConsts.REDIS_HASH_DRK, key, value);
    }

    /**
     * 消费 kafka 消息服务
     */
    public void process() {
        logger.info("一车一档 - kafka - 开始处理kafka消息...");
        start();
        // 记录待入库数量大小, 每天上限10000条
        Long drkIndex = hashOperations.size(VehicleFileConsts.REDIS_HASH_DRK);
        KafkaConsumer<String, String> consumer = null;
        try {
            consumer = consumerFactory.consumer();
        } catch (Exception e) {
            logger.error("一车一档 - kafka - 创建kafka消费者失败: ", e);
            return;
        }
        for (; ; ) {
            getHphmList("");
            if (!isProcessingKafka(drkIndex)) {
                break;
            }
            ConsumerRecords<String, String> msgList = consumer.poll(1000);
            if (null != msgList && msgList.count() > 0) {
                for (ConsumerRecord<String, String> record : msgList) {
                    List<String> hphmList = getHphmList(record.value());
                    if (hphmList == null) {
                        return;
                    }
                    for (String key : hphmList) {
                        if (isCdxxExisted(key)) {
                            continue;
                        }
                        logger.info("一车一档 - kafka - 新增待入库, value= " + key
                                + ", partition= " + record.partition() + ", offset=" + record.offset());
                        addToDrkCdxx(key, key);
                    }

                    drkIndex++;
                }
            }
        }
        if (consumer != null) {
            consumer.close();
        }
        logger.info("一车一档 - kafka - 消息处理结束!");
    }

    private List<String> getHphmList(String kafkaMsg) {
//        JSONObject msg = JSONObject.parseObject(kafkaMsg); // 先注释掉用测试数据
        JSONObject msg = JSONObject.parseObject(VehicleFileConsts.KAFKA_MSG);
        JSONArray jArr = (JSONArray) msg.get("BODY");
        if (jArr == null) {
            return null;
        }

        List<String> hphmList = new ArrayList<>();
        for (Object o : jArr) {
            JSONObject jo = (JSONObject) o;
            hphmList.add((String) jo.get("HPHM"));
        }
//        return hphmList;

        // 以下是测试数据
        List<String> tmpList = new ArrayList<>();
        tmpList.add(kafkaMsg);
        return tmpList;
    }

    /**
     * 设置消费 kafka 消息的状态 KAFKA_RUNNING
     */
    public void start() {
        kafkaProcessStatus = ProcessStatus.KAFKA_RUNNING;
    }

    /**
     * 设置消费 kafka 消息的状态 KAFKA_STOP
     */
    public void stop() {
        kafkaProcessStatus = ProcessStatus.KAFKA_STOP;
    }

    /**
     * 判断是否正在消费 kafka 消息
     */
    private boolean isProcessingKafka(Long drkIndex) {
        if (kafkaProcessStatus != ProcessStatus.KAFKA_RUNNING) {
            return false;
        }

        if (drkIndex.compareTo(maxRecords) > 0) {
            logger.info("一车一档 - kafka - 今天的待入库数量已经达到上限, 等待明天继续处理! 上限值: " + maxRecords);
            return false;
        }

        return true;
    }
}
