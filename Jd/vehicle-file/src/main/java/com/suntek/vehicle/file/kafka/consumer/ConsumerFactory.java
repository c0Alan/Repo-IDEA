package com.suntek.vehicle.file.kafka.consumer;

import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Properties;

@Repository
public class ConsumerFactory {

    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaServer;

    @Value("${spring.kafka.group-id}")
    private String groudId;

    @Value("${kafka.topics}")
    private String topics;

    @Value("${kafka.enable.auto.commit}")
    private String autoCommit;

    @Value("${kafka.auto.offset.reset}")
    private String offsetReset;

    @Value("${kafka.key.deserializer}")
    private String keyDeserializer;

    @Value("${kafka.value.deserializer}")
    private String valueDeserializer;

    public KafkaConsumer<String, String> consumer() throws Exception {
        Properties props = new Properties();
        props.put("bootstrap.servers", kafkaServer);
        props.put("group.id", groudId);
        props.put("enable.auto.commit", autoCommit);
        props.put("key.deserializer", keyDeserializer);
        props.put("value.deserializer", valueDeserializer);
        props.put("auto.offset.reset", offsetReset);
        KafkaConsumer<String, String> consumer = new KafkaConsumer(props);
        consumer.subscribe(Arrays.asList(topics));
        return consumer;
    }

}
