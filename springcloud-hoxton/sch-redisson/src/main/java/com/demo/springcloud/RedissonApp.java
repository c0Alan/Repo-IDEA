package com.demo.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.demo.springcloud.mapper")
@EnableCaching
@EnableDiscoveryClient
@SpringBootApplication
public class RedissonApp {

    public static void main(String[] args) {
        SpringApplication.run(RedissonApp.class, args);
    }
}
