package com.c0.pac.config;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer // 使用@EnableConfigServer 开启配置服务器的支持。
@EnableEurekaClient // 使用@EnableEurekaClient 开启作为Eureka Server 的客户端的支持。
public class ConfigApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ConfigApplication.class);

        /** 启动配置 */
        app.setBannerMode(Banner.Mode.OFF); // 关闭启动标语

        app.run(args);
    }

}
