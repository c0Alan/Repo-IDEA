package com.sch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableFeignClients
@EnableScheduling  //扫描定时器
@EnableDiscoveryClient
@SpringBootApplication
public class SchScheduler {

    public static void main(String[] args) {
        SpringApplication.run(SchScheduler.class, args);
    }
}
