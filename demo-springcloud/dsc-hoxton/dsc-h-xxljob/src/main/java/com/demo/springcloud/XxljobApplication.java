package com.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class XxljobApplication {

    public static void main(String[] args) {
        SpringApplication.run(XxljobApplication.class, args);
    }
}
