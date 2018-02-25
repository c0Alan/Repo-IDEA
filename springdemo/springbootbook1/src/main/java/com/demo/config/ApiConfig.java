package com.demo.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(value = {"com.demo"})
public class ApiConfig {
    public ApiConfig() {
        System.out.println("ApiConfig inited!");
    }
}
