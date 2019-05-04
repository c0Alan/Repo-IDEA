package springcloud;

import org.springframework.boot.Banner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 创建“服务消费者 ”
 * 初始化RestTemplate，用来真正发起REST请求。
 * @EnableDiscoveryClient 注解用来将当前应用加入到服务治理体系中。
 *
 * @author liuxl
 * @date 2018/4/9 21:59
 */
@EnableDiscoveryClient
@SpringBootApplication
public class EcsApplication {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplicationBuilder appBuilder = new SpringApplicationBuilder(EcsApplication.class);
        appBuilder.web(true);
        appBuilder.bannerMode(Banner.Mode.OFF);
        appBuilder.run(args);
    }

}