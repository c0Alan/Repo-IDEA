package com.demo.java.web.filter;

import com.demo.java.web.wrapper.MyCharacterEncodingRequest;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 统一全站字符编码
 *
 * @author liuxl
 * @date 2018/5/18 13:12
 */
public class CharacterEncodingFilter implements Filter {

    private FilterConfig filterConfig = null;
    //设置默认的字符编码
    private String defaultCharset = "UTF-8";

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        String charset = filterConfig.getInitParameter("charset");
        if (charset == null) {
            charset = defaultCharset;
        }
        request.setCharacterEncoding(charset);
        response.setCharacterEncoding(charset);
        response.setContentType("text/html;charset=" + charset);

        MyCharacterEncodingRequest requestWrapper = new MyCharacterEncodingRequest(request);
        chain.doFilter(requestWrapper, response);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //得到过滤器的初始化配置信息
        this.filterConfig = filterConfig;
    }

    @Override
    public void destroy() {

    }
}