package com.c0.pac.some;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class SomeApplication {
    @Value("${my.message}") // 此处通过@Value 注入的值来自于Config Server.
    private String message;

    @RequestMapping(value = "/getsome")
    public String getsome() {
        return message;
    }

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(SomeApplication.class);

        /** 启动配置 */
        app.setBannerMode(Banner.Mode.OFF); // 关闭启动标语

        app.run(args);
    }

}
