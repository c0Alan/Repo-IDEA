package com.demo.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import java.io.IOException;

/**
 * 非注解方式实现过滤器
 * 参考: https://blog.csdn.net/Microhoo_/article/details/129968379
 *
 * @author liuxl
 * @date 2024/5/27
 */
@Slf4j
@Component
public class FilterDemo implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        log.info("过滤器 FilterDemo 执行前！");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("过滤器 FilterDemo 执行后！");
    }

    @Override
    public void destroy() {

    }

    /**
     * 注册过滤器，配置过滤规则，如果不加下面的配置，则默认注册，过滤所有请求
     */
    @Bean
    public FilterRegistrationBean<Filter> getFilterRegistrationBean(FilterDemo filterDemo) {
        FilterRegistrationBean<Filter> filterRegistrationBean = new FilterRegistrationBean<>();
        filterRegistrationBean.setFilter(filterDemo);
        filterRegistrationBean.setOrder(2);
        filterRegistrationBean.addUrlPatterns("/demo/*");
        filterRegistrationBean.setName("filterDemo");
        return filterRegistrationBean;
    }
}