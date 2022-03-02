package com.demo.springcloud.config;

import com.demo.springcloud.entity.example.ConfigExample01;
import com.demo.springcloud.entity.example.ConfigExample02;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author liuxilin
 * @date 2022年02月27日 18:31
 */
@Slf4j
@ConfigurationProperties(prefix = "app.example.bean-config")
@Configuration
public class BeanExampleConfig {

    @ConfigurationProperties(prefix = "example.bean-config.example.example01")
    @Bean
    public ConfigExample01 configExample01Bean(){
        return new ConfigExample01();
    }

    @Bean
    public ConfigExample02 configExample02(ConfigExample01 configExample01Bean){
        ConfigExample02 configExample02 = new ConfigExample02();
        configExample02.setAttr1(configExample01Bean.getAttr1());
        log.info("{}", configExample02);
        return configExample02;
    }
}
