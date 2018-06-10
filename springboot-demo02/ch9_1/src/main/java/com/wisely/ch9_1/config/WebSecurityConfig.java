package com.wisely.ch9_1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

import com.wisely.ch9_1.security.CustomUserService;

/**
 * 扩展Spring Security 配置需继承WebSecurityConfigurerAdapter
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {//1

    /**
     * 注册CustomUserService 的Bean
     * @return
     */
    @Bean
    UserDetailsService customUserService() { //2
        return new CustomUserService();
    }

    /**
     * 添加我们自定义的user detail service 认证。
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()); //3

    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests() // authorizeRequests 方法来开始请求权限配置
                .anyRequest().authenticated() // 所有请求需要认证即登录后才能访问。
                .and()
                .formLogin() // 通过formLogin 方法定制登录操作。
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll() // 定制登录行为，登录页面可任意访问。
                .and()
                .logout().permitAll(); // 定制注销行为，注销请求可任意访问。
    }
}
