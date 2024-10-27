package com.demo.springcloud.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 通用 Bean 单例创建
 * @author liuxl
 * @date 2024/9/28
 */
@Configuration
public class BeanConfig {

    /**
     * 加解密工具
     */
    @Bean
    public PasswordEncoder passwordEncoder() {
        // 使用BCrypt加密密码
        return new BCryptPasswordEncoder();
    }

    /**
     * 加解密工具
     */
    @Bean
    public ObjectMapper objectMapper() {
        // 使用BCrypt加密密码
        return new ObjectMapper();
    }
}
