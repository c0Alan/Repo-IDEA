package com.springcloud;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务容错保护（Hystrix服务降级）
 *
 * @author liuxl
 * @date 2018/4/13 23:18
 */
@EnableCircuitBreaker
@EnableDiscoveryClient
@SpringBootApplication
public class EcrhApplication {

    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplicationBuilder appBuilder = new SpringApplicationBuilder(EcrhApplication.class);
        appBuilder.web(true);
        appBuilder.bannerMode(Banner.Mode.OFF);
        appBuilder.run();
    }
}
