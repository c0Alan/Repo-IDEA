package com.c0.pac.discovery;


import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer // 开启对 EurekaServer 的支持
public class DiscoveryApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(DiscoveryApplication.class);

        /** 启动配置 */
        app.setBannerMode(Banner.Mode.OFF); // 关闭启动标语

        app.run(args);
    }

}