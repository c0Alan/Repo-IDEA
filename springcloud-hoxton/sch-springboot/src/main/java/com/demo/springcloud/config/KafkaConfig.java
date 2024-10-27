package com.demo.springcloud.config;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.Arrays;

/**
 * @author liuxl
 * @date 2024/10/24
 */
@Slf4j
@Configuration
@EnableConfigurationProperties(KafkaProperties.class)
public class KafkaConfig {
    private final KafkaProperties properties;

    private AdminClient adminClient;

    public KafkaConfig(KafkaProperties properties) {
        this.properties = properties;
    }

    @PostConstruct
    public void init() {
        log.info("KafkaConfig init:" + properties);
        kafkaAdminClient().createTopics(Arrays.asList(
                new NewTopic("q_test1", 1, (short) 1),
                new NewTopic("q_test2", 1, (short) 1)
        ));
    }

    @Bean
    public AdminClient kafkaAdminClient() {
        if (adminClient == null){
            adminClient = AdminClient.create(properties.buildAdminProperties());
        }
        return adminClient;
    }
}
