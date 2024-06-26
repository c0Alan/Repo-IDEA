package com.demo.springcloud.filter;

import com.demo.springcloud.entity.RequestLogDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;

/**
 * 接口日志过滤器
 *
 * @author liuxl
 * @date 2024/5/8
 */
@Slf4j
@WebFilter(filterName = "RequestLogFilter", urlPatterns = {"/*"})
public class RequestLogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        if (isExclude(request)){
            filterChain.doFilter(servletRequest, servletResponse);
            return;
        }
        RequestLogDto requestLog = RequestLogDto.init(request);
        log.info(requestLog.getRequestLogBegin());
        filterChain.doFilter(servletRequest, servletResponse);
        log.info(requestLog.getRequestLogEnd());
    }

    @Override
    public void destroy() {

    }

    private boolean isExclude(HttpServletRequest request) {
        String uri = request.getRequestURI();
        // 过滤静态资源
        if (uri.contains(".")){
            return true;
        }
        /*String excludePrefix = "/v2/api-docs,/swagger-resources,/webjars/,/doc.html";
        for (String prefix : excludePrefix.split(",")){
            if (uri.startsWith(prefix)){
                return true;
            }
        }
        String excludeSuffix = ".html,.css,.js,.ico";
        for (String suffix : excludeSuffix.split(",")){
            if (uri.endsWith(suffix)){
                return true;
            }
        }*/
        return false;
    }
}