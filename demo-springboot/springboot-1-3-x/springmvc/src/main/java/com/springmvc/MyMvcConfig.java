package com.springmvc;

import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import com.springmvc.interceptor.DemoInterceptor;
import com.springmvc.messageconverter.MyMessageConverter;

/**
 * Spring MVC 的定制配置
 * Spring MVC 的定制配置需要我们的配置类继承一个WebMvcConfigurerAdapter 类，
 * 并在此类使用@EnableWebMvc 注解, 开启对Spring MVC 的配置支持
 *
 * @author liuxilin
 * @date 2018/6/11 20:19
 */
@Configuration
@EnableWebMvc // 1
@EnableScheduling
@ComponentScan("com.springmvc")
public class MyMvcConfig extends WebMvcConfigurerAdapter {// 2

    /**
     * 添加视图解析器
     *
     * @return
     */
    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/classes/views/");
        viewResolver.setSuffix(".jsp");
        viewResolver.setViewClass(JstlView.class);
        return viewResolver;
    }

    /**
     * 添加资源处理器
     * 静态资源映射
     *
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // addResourceLocations 指的是文件放置的目录， addResourceHandler 指的是对外暴露的访问路径。
        registry.addResourceHandler("/assets/**").addResourceLocations(
                "classpath:/assets/");// 3

    }

    /**
     * 添加拦截器
     * 通过且WcbMvcConfïgurerAdapter 的add1nterceptofs 方法来注册自定义的拦截器，
     *
     * @return
     */
    @Bean
    public DemoInterceptor demoInterceptor() {
        return new DemoInterceptor();
    }

    /**
     * 注册拦截器
     *
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {// 2
        registry.addInterceptor(demoInterceptor());
    }

    /**
     * 通过addViewControllers简化视图配置
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/index").setViewName("/index");
        registry.addViewController("/toUpload").setViewName("/upload");
        registry.addViewController("/converter").setViewName("/converter");
        registry.addViewController("/sse").setViewName("/sse");
        registry.addViewController("/async").setViewName("/async");
    }

    /**
     * 在Spring MVC 中，路径参数如果带"." 的话，"."后面的值将被忽略
     * http://localhost:8080/anno/pathvar/xx.yy  // yy 将被忽略
     * 通过重写configurePathMatch 方法可不忽略"."后面的参数，
     * @param configurer
     */
    @Override
    public void configurePathMatch(PathMatchConfigurer configurer) {
        configurer.setUseSuffixPatternMatch(false); // 设置 "."后面的参数，
    }

    /**
     * 文件上传配置
     * @return
     */
    @Bean
    public MultipartResolver multipartResolver() {
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
        multipartResolver.setMaxUploadSize(1000000);
        return multipartResolver;
    }

    /**
     * 添加数据转换器
     * @param converters
     */
    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(converter());
    }

    /**
     * 生成转换器
     * @return
     */
    @Bean
    public MyMessageConverter converter() {
        return new MyMessageConverter();
    }

}
