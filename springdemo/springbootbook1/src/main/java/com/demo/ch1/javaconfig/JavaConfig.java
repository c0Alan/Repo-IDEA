package com.demo.ch1.javaconfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class JavaConfig {
    @Bean // 生成单例实例, 实例名与方法名一样
//    @Scope("prototype") // 生成原型实例
    public ConfigDao configDao(){
        return new ConfigDao();
    }

    @Bean
    public ConfigService configService(){
        ConfigService configService = new ConfigService();
        configService.setConfigDao(configDao());
        return configService;
    }
}
