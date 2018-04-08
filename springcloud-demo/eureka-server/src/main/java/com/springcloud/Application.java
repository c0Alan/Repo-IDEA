package com.springcloud;


import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 通过@EnableEurekaServer注解启动一个服务注册中心提供给其他应用进行对话
 *
 * @author liuxl
 * @date 2018/4/8 8:00
 */
@EnableEurekaServer
@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplicationBuilder appBuilder = new SpringApplicationBuilder(Application.class);
        appBuilder.web(true);
//        appBuilder.bannerMode(Banner.Mode.OFF);
        appBuilder.run(args);
    }

}
