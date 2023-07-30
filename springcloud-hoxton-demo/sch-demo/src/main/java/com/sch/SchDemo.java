package com.sch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class SchDemo {

    public static void main(String[] args) {
        SpringApplication.run(SchDemo.class, args);
    }
}
