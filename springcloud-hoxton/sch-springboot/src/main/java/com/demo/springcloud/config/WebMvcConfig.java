package com.demo.springcloud.config;

import com.demo.springcloud.interceptor.MyInterceptor;
import com.demo.springcloud.interceptor.MyInterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
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
     * 添加拦截器
     * 拦截器多了会影响接口性能，所以尽量减少拦截器，匹配规则多了也会影响性能，尽量精确匹配
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new MyInterceptor())
//                .addPathPatterns("/**")
                .addPathPatterns("/demo/**","/demo2/**");
//                .excludePathPatterns("/login", "/register", "/v2/api-docs", "/swagger-resources", "/webjars/*", "/doc.html");

        registry.addInterceptor(new MyInterceptor2())
//                .addPathPatterns("/**")
                .addPathPatterns("/demo/**","/demo2/**");
//                .excludePathPatterns("/login", "/register", "/v2/api-docs", "/swagger-resources", "/webjars/*", "/doc.html");
    }
}
