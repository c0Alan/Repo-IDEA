package com.demo.ch2.initdestroy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.demo.ch2.initdestroy")
public class InitDestroyConfig {
    @Bean(initMethod = "init", destroyMethod = "destroy")
    public BeanService beanService(){
        return new BeanService();
    }

    @Bean
    public JSR250Service jsr250Service(){
        return new JSR250Service();
    }
}
