package com.demo.springcloud.listener;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.demo.springcloud.entity.User;
import com.demo.springcloud.service.MybatisService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * kafka 消费者监听器
 *
 * @author liuxilin
 * @date 2022/2/19 22:18
 */
@Slf4j
@Component
public class KafkaConsumerListener {

    @Autowired
    MybatisService mybatisService;

    /**
     * 批量消费消息
     *
     * @param records
     */
    @KafkaListener(topics = {"q_dsc_user"}, containerFactory = "batchFactory")
    public void consumerBatch(List<ConsumerRecord<?, ?>> records, Acknowledgment acknowledgment) {
        try {
            log.info("接收到消息数量：{}", records.size());
            List<User> userList = new ArrayList<>();
            records.forEach(record -> {
                String message = (String) record.value();
                JSONObject jsonObject = JSONUtil.parseObj(message);
                User user = BeanUtil.toBean(jsonObject, User.class);
                userList.add(user);
                log.info("收到消息: {}", message);
            });
            mybatisService.saveUserList(userList);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            // 手动提交 offset
            acknowledgment.acknowledge();
        }
    }

}
