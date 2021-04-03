package com.springcloud;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 分布式配置中心-服务端
 * 
 * @author liuxl
 * @date 2018/4/12 7:48
 */
@EnableConfigServer
@SpringBootApplication
public class CsgApplication {

    public static void main(String[] args) {
        SpringApplicationBuilder appBuilder = new SpringApplicationBuilder(CsgApplication.class);
        appBuilder.web(true);
        appBuilder.bannerMode(Banner.Mode.OFF);
        appBuilder.run(args);
    }

}