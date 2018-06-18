package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * 缓存
 * 
 * @author liuxilin
 * @date 2018/6/14 20:46
 */
@SpringBootApplication
@EnableCaching
public class Ch85Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch85Application.class, args);
    }
}
