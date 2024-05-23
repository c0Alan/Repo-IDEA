package com.demo.java.web.filter;

import com.demo.java.web.wrapper.MyHtmlRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * html转义过滤器
 *
 * @author liuxilin
 * @date 2018/5/17 21:41
 */
public class HtmlFilter implements Filter {

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        MyHtmlRequest myrequest = new MyHtmlRequest(request);
        chain.doFilter(myrequest, response);

    }


    public void destroy() {

    }


    public void init(FilterConfig filterConfig) throws ServletException {

    }
}