package com.mybatis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages="com")
@EnableAutoConfiguration
public class Application {  
    public static void main(String[] args) {
        SpringApplication api = new SpringApplication(Application.class);
        api.run(args);
    }  
}  