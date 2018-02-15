package com.api.shiro.jpa.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = {"com.hibernate.dao"})
@EntityScan(basePackages = {"com.hibernate.model"})
public class JpaConfig {
    public JpaConfig() {
        System.out.println("JpaConfig inited!");
    }
}