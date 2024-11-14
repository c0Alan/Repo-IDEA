package com.demo.springcloud.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * SpringMVC配置
 *
 * @author liuxl
 * @date 2024/5/27
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    /**
     * 添加静态资源映射
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        //将所有/static/** 访问都映射到classpath:/static/ 目录下
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }

    /**
     * 跨域CORS配置
     * 参考: https://blog.csdn.net/cowbin2012/article/details/85194353
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/demo/**")
                .allowedHeaders("*")
                .allowedMethods("POST","GET")
                .allowedOrigins("*");
    }



}
