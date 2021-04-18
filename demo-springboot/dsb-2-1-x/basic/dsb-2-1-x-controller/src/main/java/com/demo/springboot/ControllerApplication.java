package com.demo.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 *
 */
@SpringBootApplication
public class ControllerApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(ControllerApplication.class);
        app.run(args);
    }

}
