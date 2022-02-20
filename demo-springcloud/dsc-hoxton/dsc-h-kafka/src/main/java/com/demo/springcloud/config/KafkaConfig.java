package com.demo.springcloud.config;

import com.demo.springcloud.constant.KafkaConsts;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.Consumer;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.autoconfigure.kafka.KafkaProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.*;
import org.springframework.kafka.listener.BatchAcknowledgingConsumerAwareMessageListener;
import org.springframework.kafka.listener.ContainerProperties;
import org.springframework.kafka.listener.KafkaMessageListenerContainer;
import org.springframework.kafka.listener.adapter.RecordFilterStrategy;
import org.springframework.kafka.support.Acknowledgment;

import java.util.List;

/**
 * kafka 生产者配置类
 *
 * @author liuxilin
 * @date 2022/2/19 20:43
 */
@Slf4j
@AllArgsConstructor
@EnableKafka
@EnableConfigurationProperties({KafkaProperties.class})
@Configuration
public class KafkaConfig {
    private final KafkaProperties kafkaProperties;

    /*********************************************
     * admin相关
     *
     ********************************************/

    @Bean
    public KafkaAdmin kafkaAdmin() {
        KafkaAdmin admin = new KafkaAdmin(kafkaProperties.buildAdminProperties());
        return admin;
    }

    @Bean
    public AdminClient adminClient() {
        return AdminClient.create(kafkaProperties.buildAdminProperties());
    }

    /*********************************************
     * 生产者相关
     *
     ********************************************/

    @Bean
    public KafkaTemplate<String, String> kafkaTemplate() {
        return new KafkaTemplate<>(producerFactory());
    }

    @Bean
    public ProducerFactory<String, String> producerFactory() {
        return new DefaultKafkaProducerFactory<>(kafkaProperties.buildProducerProperties());
    }

    /*********************************************
     * 消费者相关
     *
     ********************************************/
    @Bean
    public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
        ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory());
        factory.setConcurrency(KafkaConsts.DEFAULT_PARTITION_NUM);
        factory.setBatchListener(true);
        factory.getContainerProperties().setPollTimeout(3000);
        return factory;
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory() {
        return new DefaultKafkaConsumerFactory<>(kafkaProperties.buildConsumerProperties());
    }

    @Bean
    public KafkaListenerContainerFactory<?> batchFactory(ConsumerFactory consumerFactory) {
        ConcurrentKafkaListenerContainerFactory<Integer, String> factory =
                new ConcurrentKafkaListenerContainerFactory<>();
        factory.setConsumerFactory(consumerFactory);
        factory.setConcurrency(10);
        factory.getContainerProperties().setPollTimeout(1500);
        //设置为批量消费，每个批次数量在Kafka配置参数中设置ConsumerConfig.MAX_POLL_RECORDS_CONFIG
        factory.setBatchListener(true);
        // factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);//设置提交偏移量的方式
        return factory;
    }

    /**
     * 设置手动提交
     *
     * @param consumerFactory
     * @return
     */
    @Bean("ackContainerFactory")
    public ConcurrentKafkaListenerContainerFactory ackContainerFactory(
            ConsumerFactory consumerFactory) {
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
        factory.getContainerProperties().setAckMode(ContainerProperties.AckMode.MANUAL_IMMEDIATE);
        factory.setConsumerFactory(consumerFactory);
        factory.setConcurrency(KafkaConsts.DEFAULT_PARTITION_NUM);
        return factory;
    }

    /**
     * 消息过滤
     *
     * @return
     */
    @Bean
    public ConcurrentKafkaListenerContainerFactory filterContainerFactory(ConsumerFactory consumerFactory) {
        ConcurrentKafkaListenerContainerFactory factory = new ConcurrentKafkaListenerContainerFactory();
        factory.setConsumerFactory(consumerFactory);
        //配合RecordFilterStrategy使用，被过滤的信息将被丢弃
        factory.setAckDiscarded(true);
        factory.setRecordFilterStrategy(new RecordFilterStrategy() {
            @Override
            public boolean filter(ConsumerRecord consumerRecord) {
                String msg = (String) consumerRecord.value();
                if (msg.contains("abc")) {
                    return false;
                }
                log.info("filterContainerFactory filter : " + msg);
                //返回true将会被丢弃
                return true;
            }
        });
        return factory;
    }

    @Bean
    public KafkaMessageListenerContainer demoListenerContainer(ConsumerFactory consumerFactory) {
        ContainerProperties properties = new ContainerProperties("q_dsc_test6");
        properties.setGroupId("dsc-h-kafka");
      /*
      //批量消费
      properties.setMessageListener(new MessageListener<Integer,String>() {
            @Override
            public void onMessage(ConsumerRecord<Integer, String> record) {
                log.info("topic3: " + record.toString());
            }
        });*/

        //批量消费
        properties.setMessageListener(
                new BatchAcknowledgingConsumerAwareMessageListener<String, String>() {
                    @Override
                    public void onMessage(List<ConsumerRecord<String, String>> list,
                                          Acknowledgment acknowledgment, Consumer<?, ?> consumer) {
                        log.info("size:{}", list.size());
                    }
                });
        return new KafkaMessageListenerContainer(consumerFactory, properties);
    }

    /*********************************************
     * 主题创建
     *
     ********************************************/
    /**
     * 创建一个名为testtopic的Topic并设置分区数为8，分区副本数为2
     */
    @Bean
    public NewTopic initialTopic() {
        return new NewTopic("q_dsc_test5", 2, (short) 1);
    }

    /**
     * 如果要修改分区数，只需修改配置值重启项目即可
     * 修改分区数并不会导致数据的丢失，但是分区数只能增大不能减小
     * @return
     */
    @Bean
    public NewTopic updateTopic() {
        return new NewTopic("q_dsc_test5", 4, (short) 1);
    }

}


