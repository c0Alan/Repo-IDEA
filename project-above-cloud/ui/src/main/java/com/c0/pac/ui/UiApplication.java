package com.c0.pac.ui;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 入口:
 * Spring Cloud 使用@EnableCircuitBreaker 来启用断路器支持，
 * 使用@HystrixCommand 的fallbackMethod 来指定后备方法。
 * @author liuxl
 * @date 2018/3/26 23:33
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients // 通过@EnableFeignClients 开启feign 客户端支持。
@EnableCircuitBreaker // 通过@EnableCircuitBreaker 开启CircuitBreaker 的支持。 来启用断路器支持.
@EnableZuulProxy // 通过@EnableZuulProxy 开启网关代理的支持
public class UiApplication {

    // 启动的时候要注意，由于我们在controller中注入了RestTemplate，
    // 所以启动的时候需要实例化该类的一个实例
//    @Autowired
//    private RestTemplateBuilder builder;

    /**
     * 使用RestTemplateBuilder来实例化RestTemplate对象，
     * spring默认已经注入了RestTemplateBuilder实例
     * @return
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

	public static void main(String[] args) {
        SpringApplication app = new SpringApplication(UiApplication.class);

        /** 启动配置 */
        app.setBannerMode(Banner.Mode.OFF); // 关闭启动标语

        app.run(args);
    }
}
