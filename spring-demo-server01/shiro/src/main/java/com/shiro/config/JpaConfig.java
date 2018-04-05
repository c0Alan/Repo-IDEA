package com.shiro.config;

// 不用 jpa 配置类都可以
//@Configuration
//@EntityScan(basePackages = {"com.shiro.model"})
//@EnableJpaRepositories(basePackages = {"com.shiro.dao"})
public class JpaConfig {
    public JpaConfig() {
        System.out.println("JpaConfig inited!");
    }
}