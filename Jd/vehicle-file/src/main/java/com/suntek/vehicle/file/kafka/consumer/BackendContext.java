package com.suntek.vehicle.file.kafka.consumer;

import com.google.common.base.Splitter;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

//@Service
public class BackendContext {

    @Value("${spring.kafka.bootstrap-servers}")
    private String kafkaServer;

    @Value("${spring.kafka.group-id}")
    private String groudId;

    @Value("${kafka.topics}")
    private String topics;

    @Bean
    public KafkaConsumer<String, String> consumer() throws Exception {
        Properties props = new Properties();
        props.put("bootstrap.servers", kafkaServer);
        props.put("group.id", groudId);
        props.put("enable.auto.commit", "false");
        props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");
        props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer");

        KafkaConsumer<String, String> consumer = new KafkaConsumer(props);
        consumer.subscribe(Splitter.on(",").splitToList(topics));
        return consumer;
    }

}