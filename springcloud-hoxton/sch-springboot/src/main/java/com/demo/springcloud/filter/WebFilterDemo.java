package com.demo.springcloud.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @WebFilter 方式定义过滤器，需要在启动类中加@ServletComponentScan注解
 * 参考: https://blog.csdn.net/Microhoo_/article/details/129968379
 *
 * @author liuxilin
 * @date 2023-08-13 16:11
 */
@Slf4j
@Order(5)
@WebFilter(filterName = "WebFilterDemo", urlPatterns = {"/demo2/*"}, initParams = {@WebInitParam(name = "excludes", value = "/exclude")})
public class WebFilterDemo implements Filter {
    private List<String> exclusions = null;

    @Override
    public void init(FilterConfig filterConfig) {
        String excludes = filterConfig.getInitParameter("excludes");
        if (excludes != null) {
            String[] arr = excludes.split(",");
            exclusions = Arrays.asList(arr);
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String requestUri = request.getRequestURI();
        if (exclusions.contains(requestUri)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        log.info("过滤器 WebFilterDemo 执行前！");
        filterChain.doFilter(servletRequest, servletResponse);
        log.info("过滤器 WebFilterDemo 执行后！");
    }

    @Override
    public void destroy() {
        log.info("filter 销毁");
    }

}
