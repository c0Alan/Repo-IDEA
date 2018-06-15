package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 我们还可以通过SSH 或TELNET 监控和管理我们的应用，
 * 这一点Spring Boot 是借助CraSH ( http://www.crashub.org )来实现的
 * 
 * @author liuxilin
 * @date 2018/6/15 22:45
 */
@SpringBootApplication
public class Ch123Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch123Application.class, args);
    }
}
