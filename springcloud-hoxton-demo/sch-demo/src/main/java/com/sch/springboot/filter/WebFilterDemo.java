package com.sch.springboot.filter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 参考：https://www.cnblogs.com/huanzi-qch/p/11239167.html
 *
 * @author liuxilin
 * @date 2023-08-13 16:11
 */
@Slf4j
@Order(5)
@WebFilter(filterName = "WebFilterDemo", urlPatterns = {"/*"},
        initParams = {
                @WebInitParam(name = "excludeUrl", value = "/exclude")
        })
public class WebFilterDemo implements Filter {
    private String exclusions = null;

    @Override
    public void init(FilterConfig filterConfig) {
        exclusions = filterConfig.getInitParameter("excludeUrl");
        //项目启动时初始化,只始化一次
        log.info("filter 初始化,excludeUrl:" + exclusions);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        log.info(request.getRequestURI());
        if (request.getRequestURI().equals(exclusions)) {
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        log.info("WebFilterDemo 过滤器执行！");

        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        log.info("filter 销毁");
    }
}
