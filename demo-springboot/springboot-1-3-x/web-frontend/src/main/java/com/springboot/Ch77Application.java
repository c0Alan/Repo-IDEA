package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * 测试路劲: http://localhost:8080/action.html
 *
 * @author liuxilin
 * @date 2018/6/12 22:51
 */
@RestController
@SpringBootApplication
public class Ch77Application {

    @RequestMapping(value = "/search", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Person search(String personName) {

        return new Person(personName, 32, "hefei");
    }

    public static void main(String[] args) {
        SpringApplication.run(Ch77Application.class, args);
    }
}
