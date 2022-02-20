package com.demo.springcloud.config;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.AdminClient;
import org.apache.kafka.clients.admin.CreateTopicsResult;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * @author liuxilin
 * @date 2022年02月20日 11:02
 */
@Data
@Slf4j
@ConfigurationProperties(prefix = "app.kafka")
@Configuration
public class AppKafkaConfig {

    /** 不能直接注入 NewTopic 对象，没有getter方法，字段为private*/
    List<Topic> topics;

    @Autowired
    AdminClient adminClient;

    @Data
    static class Topic {
        String name;
        Integer numPartitions = 3;
        Short replicationFactor = 1;

        NewTopic toNewTopic() {
            return new NewTopic(this.name, this.numPartitions, this.replicationFactor);
        }
    }

    @PostConstruct
    public void init() {
        List<NewTopic> newTopics = new ArrayList<>();
        topics.forEach(t -> newTopics.add(t.toNewTopic()));
        CreateTopicsResult result = adminClient.createTopics(newTopics);
        log.info("{}", newTopics);
    }


}
