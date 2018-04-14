package com.springcloud;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.turbine.stream.EnableTurbineStream;
import org.springframework.context.annotation.Configuration;

/**
 * 可以通过 http://localhost:8989/turbine.stream 监控
 * 但是在 Eureka Server 上无法显示该服务, 貌似没注册上, tuibine 却可以
 * 
 * @author liuxl
 * @date 2018/4/14 18:58
 */
@Configuration
@EnableAutoConfiguration
@EnableTurbineStream
@EnableDiscoveryClient
public class TaApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(TaApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
}
