package com.demo.springcloud.config;

import com.demo.springcloud.interceptor.MyInterceptor;
import com.demo.springcloud.interceptor.MyInterceptor2;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

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


    /**
     * 添加视图映射
     *
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //实现一个请求到视图的映射，而无需书写controller
        registry.addViewController("/index").setViewName("forward:/index.html");
        registry.addViewController("/cors").setViewName("forward:/cors.html");
    }

}
