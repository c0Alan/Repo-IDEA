package com.demo.springcloud.service.kafka;

import com.demo.springcloud.listener.KafkaFutureCallback;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


/**
 * kafka 生产者 service
 *
 * @author liuxilin
 * @date 2022/2/19 21:17
 */
@Slf4j
@Service
public class KafkaProducerService {

    @Autowired
    private KafkaTemplate kafkaTemplate;


    public void send(String topic, String msg) {
        ProducerRecord record = new ProducerRecord(topic, msg);
        kafkaTemplate.send(record).addCallback(new KafkaFutureCallback());
    }
}
