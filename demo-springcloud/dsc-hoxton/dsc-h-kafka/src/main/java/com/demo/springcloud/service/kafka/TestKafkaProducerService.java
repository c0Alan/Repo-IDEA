package com.demo.springcloud.remote.kafka;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;


/**
 * kafka 生产者 service
 *
 * @author liuxilin
 * @date 2022/2/19 21:17
 */
@Slf4j
@Service
public class TestKafkaProducerService {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    public String send(@RequestParam String topic, @RequestParam String msg) {
        // template.setProducerListener(producerListener);
        //发送带有时间戳的消息
        kafkaTemplate.send(topic, 0, System.currentTimeMillis(), "0", msg);

        //使用ProducerRecord发送消息
        ProducerRecord record = new ProducerRecord(topic, msg);
        kafkaTemplate.send(record);

        //使用Message发送消息
        Map map = new HashMap();
        map.put(KafkaHeaders.TOPIC, topic);
        map.put(KafkaHeaders.PARTITION_ID, 0);
        map.put(KafkaHeaders.MESSAGE_KEY, "0");
        GenericMessage message = new GenericMessage(msg, new MessageHeaders(map));
        kafkaTemplate.send(message);
        return "success";
    }

    public String batchSendMsg(@RequestParam String topic, @RequestParam int count, @RequestParam String msg) {
        for (int i = 0; i < count; i++) {
            kafkaTemplate.send(topic, msg);
        }
        return "send success";
    }

    public String producerListen(@RequestParam String topic, @RequestParam String msg) throws InterruptedException {
        kafkaTemplate.send(topic, msg);
        return "success";
    }

    public String syncMsg(@RequestParam String topic, @RequestParam String msg) {
        try {
            kafkaTemplate.send(topic, msg).get();
        } catch (InterruptedException e) {
            log.error("{}", e);
        } catch (ExecutionException e) {
            log.error("{}", e);
        }
        return "success";
    }

}
