package com.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Ch523Application {

    public static void main(String[] args) {
        SpringApplication.run(Ch523Application.class, args);
    }

    @RequestMapping("/")
    String home() {
        return "Hello Spring Boot!";
    }
}
