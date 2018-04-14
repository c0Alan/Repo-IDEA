package com.rabbitmq;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RabbitmqApplication {
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(RabbitmqApplication.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run();
    }
}
