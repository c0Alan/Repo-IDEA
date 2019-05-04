package com.springboot;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Springboot 启动类, 默认会加载 resources 路劲下的 application.properties 文件
 * 
 * @author liuxilin
 * @date 2018/6/11 23:05
 */
@RestController
@SpringBootApplication
public class Ch522Application {

    @Value("${book.author}")
    private String bookAuthor;
    @Value("${book.name}")
    private String bookName;

    @RequestMapping("/")
    String index() {
        return "book name is:" + bookName + " and book author is:" + bookAuthor;
    }

    public static void main(String[] args) {
        SpringApplication.run(Ch522Application.class, args);
    }
}
