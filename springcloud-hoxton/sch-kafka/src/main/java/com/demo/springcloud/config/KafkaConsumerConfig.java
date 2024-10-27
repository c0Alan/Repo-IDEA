package com.demo.springcloud.config;

import cn.hutool.core.util.StrUtil;
import com.alibaba.cloud.nacos.NacosDiscoveryProperties;
import lombok.Data;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ContainerProperties;

import java.util.HashMap;
import java.util.Map;

/**
 * kafka消费者配置类
 */
@Configuration
@Data
public class KafkaConsumerConfig {


    @Value("${spring.kafka.consumer.bootstrap-servers}")
    private String servers;
    @Value("${spring.kafka.consumer.enable-auto-commit}")
    private boolean enableAutoCommit;
    @Value("${spring.kafka.consumer.heartbeat-interval}")
    private int sessionTimeout;
    @Value("${spring.kafka.consumer.auto-commit-interval}")
    private int autoCommitInterval;
    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;
    @Value("${spring.kafka.consumer.auto-offset-reset}")
    private String autoOffsetReset;
    @Value("${spring.kafka.listener.concurrency:1}")
    private int concurrency;
    @Value("${spring.kafka.listener.poll-timeout}")
    private int maxPollInterval;
    @Value("${spring.kafka.consumer.max-poll-records}")
    private int maxPollRecords;

    @Value("${spring.kafka.listener.auto-startup:true}")
    private Boolean autoStartup;

    @Value("${spring.kafka.consumer.user-name:}")
    private String userName;
    @Value("${spring.kafka.consumer.password:}")
    private String password;

    @Autowired
    private NacosDiscoveryProperties discoveryProperties;

    @Value("${server.port}")
    private int port;


    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(concurrency);
        factory.getContainerProperties().setPollTimeout(61 * 1000);
        factory.setBatchListener(true);
//        factory.setAutoStartup(autoStartup);
//        //设置提交偏移量的方式
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        return factory;
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(consumerConfigs());
    }

    public Map<String, Object> consumerConfigs() {
        Map<String, Object> propsMap = new HashMap<>();
        propsMap.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, servers);
        propsMap.put(ConsumerConfig.SESSION_TIMEOUT_MS_CONFIG, sessionTimeout);
        propsMap.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        propsMap.put(ConsumerConfig.GROUP_ID_CONFIG, getGroupId());
        propsMap.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
        propsMap.put(ConsumerConfig.MAX_POLL_INTERVAL_MS_CONFIG, maxPollInterval);
        //每一批数量
        propsMap.put(ConsumerConfig.MAX_POLL_RECORDS_CONFIG, maxPollRecords);

        if (StrUtil.isNotBlank(userName)) {
            propsMap.put("security.protocol", "SASL_PLAINTEXT");
            propsMap.put("sasl.mechanism", "PLAIN");
            propsMap.put("sasl.jaas.config", "org.apache.kafka.common.security.plain.PlainLoginModule required username=\""
                    + userName + "\" password=\"" + password + "\";");
        }
        return propsMap;
    }


    public String getGroupId() {
        //以* 结尾的代表每个服务都需要消费
        if (groupId.endsWith("*")) {
            return groupId.substring(0, groupId.length() - 1) + discoveryProperties.getIp() + ":" + port;
        }
        return groupId;
    }


    //    @Bean
//    public NewTopic platDevPositionTopic() {
//
//        return new NewTopic(KafkaConstant.PLAT_DEV_POSITION_TOPIC, 1, (short) 1);
//
//    }
}
