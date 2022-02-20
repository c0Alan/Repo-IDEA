package com.demo.springcloud.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * 
 * @author liuxilin
 * @date 2022/2/20 9:36
 */
@Slf4j
@Component
public class KafkaFilterListener {

    @KafkaListener(topics = {"filter_topic"}, containerFactory = "filterContainerFactory", autoStartup = "false")
    public void consumerBatch(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("record =" + record);
            log.info("接收到消息数量：{}", message);
        }

    }
}
