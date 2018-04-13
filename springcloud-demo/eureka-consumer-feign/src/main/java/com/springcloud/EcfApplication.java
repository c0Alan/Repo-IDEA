package com.springcloud;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 服务消费（Feign）
 *
 * @author liuxl
 * @date 2018/4/12 7:37
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
public class EcfApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplicationBuilder appBuilder = new SpringApplicationBuilder(EcfApplication.class);
        appBuilder.web(true);
        appBuilder.bannerMode(Banner.Mode.OFF);
        appBuilder.run(args);
    }

}