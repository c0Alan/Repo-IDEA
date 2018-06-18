package com.springboot;

import com.springboot.config.AuthorSettings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 常规属性配置
 * 
 * @author liuxilin
 * @date 2018/6/17 9:40
 */
@RestController
@SpringBootApplication
public class Ch623Application {

    @Autowired
    private AuthorSettings authorSettings;

    @RequestMapping("/")
    public String index() {
        return "author name is " + authorSettings.getName() +
                " and author age is " + authorSettings.getAge();
    }

    public static void main(String[] args) {
        SpringApplication.run(Ch623Application.class, args);
    }
}
