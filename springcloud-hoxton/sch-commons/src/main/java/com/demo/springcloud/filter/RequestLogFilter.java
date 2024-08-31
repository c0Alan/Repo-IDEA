package com.demo.springcloud.filter;

import com.demo.springcloud.entity.RequestLogDto;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 接口日志过滤器
 *
 * @author liuxl
 * @date 2024/5/8
 */
@Slf4j
// @WebFilter 不加 asyncSupported = true 会导致sse请求报错：Async support must be enabled
@WebFilter(filterName = "RequestLogFilter", urlPatterns = {"/*"}, asyncSupported = true)
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
        RequestLogDto requestLog = RequestLogDto.of(request);
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
        return false;
    }
}