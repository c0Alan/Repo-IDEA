package com.demo.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@ServletComponentScan
@EnableDiscoveryClient
@SpringBootApplication
public class ElasticsearchApp {

    public static void main(String[] args) {
        SpringApplication.run(ElasticsearchApp.class, args);
    }
}
