package com.springboot.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer // 使用@EnableConfigServer 开启配置服务器的支持。
@EnableEurekaClient // 使用@EnableEurekaClient 开启作为Eureka Server 的客户端的支持。
public class ConfigApplication {
	
	 public static void main(String[] args) {
	        SpringApplication.run(ConfigApplication.class, args);
	    }

}
