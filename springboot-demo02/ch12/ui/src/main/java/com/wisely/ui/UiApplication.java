package com.springboot.ui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * 入口:
 * Spring Cloud 使用@EnableCircuitBreaker 来启用断路器支持，
 * 使用@HystrixCommand 的fallbackMethod 来指定后备方法。
 * @author liuxl
 * @date 2018/3/26 23:33
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients // 通过@EnableFeignClients 开启feign 客户端支持。
@EnableCircuitBreaker // 通过@EnableCircuitBreaker 开启CircuitBreaker 的支持。 来启用断路器支持.
@EnableZuulProxy // 通过@EnableZuulProxy 开启网关代理的支持
public class UiApplication {
	public static void main(String[] args) {
        SpringApplication.run(UiApplication.class, args);
    }
}
