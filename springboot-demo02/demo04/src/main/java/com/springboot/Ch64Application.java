package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * profile 配置实例
 * 启动时会打印: Tomcat started on port(s): 8089
 * 
 * @author liuxl
 * @date 2018/6/12 12:30
 */
@SpringBootApplication
public class Ch64Application {

    public static void main(String[] args) { 
        SpringApplication.run(Ch64Application.class, args);
    }
}
