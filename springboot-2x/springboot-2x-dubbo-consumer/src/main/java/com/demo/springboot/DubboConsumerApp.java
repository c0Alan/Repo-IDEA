package com.demo.springboot;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubboConfiguration
@SpringBootApplication
public class DubboConsumerApp {

	public static void main(String[] args) {
		SpringApplication.run(DubboConsumerApp.class, args);
	}

}
