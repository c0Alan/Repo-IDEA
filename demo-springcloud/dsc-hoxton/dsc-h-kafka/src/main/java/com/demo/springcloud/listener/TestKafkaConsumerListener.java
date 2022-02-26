package com.demo.springcloud.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * kafka 消费者监听器，测试类
 *
 * @author liuxilin
 * @date 2022/2/19 22:18
 */
@Slf4j
@Component
public class TestKafkaConsumerListener {
    /**
     * 单条消息
     *
     * @param record
     */
    @KafkaListener(topics = {"q_dsc_test2"}, autoStartup = "false")
    public void consumer(ConsumerRecord<?, ?> record) {
        Optional<?> kafkaMessage = Optional.ofNullable(record.value());
        if (kafkaMessage.isPresent()) {
            Object message = kafkaMessage.get();
            log.info("record =" + record);
            log.info(" message =" + message);
        }
    }

    /**
     * 批量消息
     *
     * @param record
     */
    @KafkaListener(topics = {"q_dsc_test"}, containerFactory = "batchFactory", autoStartup = "false")
    public void consumerBatch(List<ConsumerRecord<?, ?>> record) {
        log.info("接收到消息数量：{}", record.size());
    }

    @KafkaListener(id = "group3", topics = "q_dsc_test3", autoStartup = "false")
    public void annoListener(@Payload String data,
                             @Header(KafkaHeaders.RECEIVED_MESSAGE_KEY) String key,
                             @Header(KafkaHeaders.RECEIVED_PARTITION_ID) String partition,
                             @Header(KafkaHeaders.RECEIVED_TOPIC) String topic,
                             @Header(KafkaHeaders.RECEIVED_TIMESTAMP) String ts) {
        log.info(" receive : \n" +
                "data : " + data + "\n" +
                "key : " + key + "\n" +
                "partitionId : " + partition + "\n" +
                "topic : " + topic + "\n" +
                "timestamp : " + ts + "\n"
        );
    }

    @KafkaListener(id = "ack", topics = "ack", containerFactory = "ackContainerFactory", autoStartup = "false")
    public void ackListener(ConsumerRecord record, Acknowledgment ack) {
        log.info("receive : " + record.value());
        //手动提交
        ack.acknowledge();
    }

    @KafkaListener(topics = "q_dsc_test7", containerFactory = "ackContainerFactory", autoStartup = "false")
    public void handleMessage(ConsumerRecord record, Acknowledgment acknowledgment) {
        try {
            String message = (String) record.value();
            log.info("收到消息: {}", message);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        } finally {
            // 手动提交 offset
            acknowledgment.acknowledge();
        }
    }


}
