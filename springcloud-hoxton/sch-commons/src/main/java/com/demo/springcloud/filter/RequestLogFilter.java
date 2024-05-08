package com.demo.springcloud.filter;

import com.demo.springcloud.entity.RequestLogDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 接口日志过滤器
 *
 * @author liuxl
 * @date 2024/5/8
 */
@Slf4j
@Component
public class RequestLogFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        RequestLogDto requestLog = RequestLogDto.init(request);
        log.info(requestLog.getRequestLogBegin());
        filterChain.doFilter(servletRequest, servletResponse);
        log.info(requestLog.getRequestLogEnd());
    }

    @Override
    public void destroy() {

    }
}