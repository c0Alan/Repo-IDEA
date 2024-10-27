package com.demo.springcloud.kafka;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author liuxl
 * @date 2024/10/21
 */
@Component
public class KafkaConsumer {

    //监听消费
    @KafkaListener(topics = {"Q_TEST"})
    public void onNormalMessage(List<ConsumerRecord<String, String>> records, Acknowledgment ack) {
        records.forEach(record -> {
            System.out.println("topic:" + record.topic() + " partition:" + record.partition() + " offset:" + record.offset() + " value:" + record.value());
        });
    }

}
 