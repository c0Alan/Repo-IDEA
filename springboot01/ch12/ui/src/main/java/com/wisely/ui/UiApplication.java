package com.wisely.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 入口:
 * 
 * @author liuxl
 * @date 2018/3/26 23:33
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients // 通过@EnableFeignClients 开启feign 客户端支持。
@EnableCircuitBreaker // 通过@EnableCircuitBreaker 开启CircuitBreaker 的支持。
@EnableZuulProxy // 通过@EnableZuulProxy 开启网关代理的支持
public class UiApplication {
	public static void main(String[] args) {
        SpringApplication.run(UiApplication.class, args);
    }
}
