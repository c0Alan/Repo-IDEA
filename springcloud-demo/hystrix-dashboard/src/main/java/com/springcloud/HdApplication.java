package com.springcloud;

import org.springframework.boot.Banner;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

/**
 * hystrix 监控面板
 * 
 * @author liuxl
 * @date 2018/4/14 8:50
 */
@EnableHystrixDashboard
@SpringCloudApplication
public class HdApplication {
    public static void main(String[] args) {
        SpringApplicationBuilder appBuilder = new SpringApplicationBuilder(HdApplication.class);
        appBuilder.bannerMode(Banner.Mode.OFF);
        appBuilder.run();
    }
}
