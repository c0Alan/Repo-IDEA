package com.demo.springcloud.config;

import io.etcd.jetcd.Client;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;
import java.util.List;

/**
 * @author liuxilin
 * @date 2022/2/26 13:32
 */
@Data
@Slf4j
@ConfigurationProperties(prefix = "etcd")
@Configuration
public class EtcdConfig {

    @Value("#{'${etcd.endpoints:http://localhost:2379}'.split(',')}")
    private List<String> nodes;

    @PostConstruct
    public void init() {
        log.info("{}", nodes);
    }

    @Bean
    public Client etcdClient(){
        Client client = Client.builder().endpoints("http://172.25.20.57:2379").build();
        return client;
    }

}