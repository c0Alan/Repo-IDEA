package com.springcloud;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 创建“服务提供方”
 * @EnableDiscoveryClient 注解，该注解能激活Eureka中的DiscoveryClient实现，
 * 这样才能实现Controller中对服务信息的输出。
 *
 * @author liuxl
 * @date 2018/4/9 21:59
 */
@EnableDiscoveryClient
@SpringBootApplication
public class CcApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder appBuilder = new SpringApplicationBuilder(CcApplication.class);
        appBuilder.web(true);
        appBuilder.bannerMode(Banner.Mode.OFF);
        appBuilder.run(args);
    }

}