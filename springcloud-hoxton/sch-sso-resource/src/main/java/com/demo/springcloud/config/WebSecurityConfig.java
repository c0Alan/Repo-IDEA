package com.demo.springcloud.config;


import com.demo.springcloud.filter.JwtVerificationFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * sso单点登录配置
 * 参考：https://oollxianluo.blog.csdn.net/article/details/127575556
 * 
 * @author liuxl
 * @date 2024/10/6
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/doc.html", "/webjars/**", "/v2/api-docs", "/v3/api-docs/**", "/swagger-ui/**", "/swagger-resources/**");
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        //禁用csrf保护机制
        http.csrf().disable();
        //禁用cors保护机制
        http.cors().disable();
        //禁用session会话
        http.sessionManagement().disable();
        //禁用form表单登录
        http.formLogin().disable();
        //增加自定义验证过滤器（资源服务需要配置）
        http.addFilter(new JwtVerificationFilter(super.authenticationManager()));
    }
}