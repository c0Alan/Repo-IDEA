package com.demo.springcloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@MapperScan("com.demo.springcloud.mapper")
@ServletComponentScan
@EnableDiscoveryClient
@SpringBootApplication
public class OauthServerApp {

    public static void main(String[] args) {
        SpringApplication.run(OauthServerApp.class, args);
    }
}
