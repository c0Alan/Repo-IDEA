package com.sch;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.sch.mapper")
@ServletComponentScan
@EnableDiscoveryClient
@SpringBootApplication
public class SchDemo {

    public static void main(String[] args) {
        SpringApplication.run(SchDemo.class, args);
    }
}
