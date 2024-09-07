package com.demo.springcloud;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableAdminServer
@ServletComponentScan
@EnableDiscoveryClient
@SpringBootApplication
public class AdminServerApp {

    public static void main(String[] args) {
        SpringApplication.run(AdminServerApp.class, args);
    }
}
