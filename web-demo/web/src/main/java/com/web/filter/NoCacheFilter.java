package com.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 禁止浏览器缓存所有动态页面
 * Expires数据头：值为GMT时间值，为-1指浏览器不要缓存页面
 * Cache-Control响应头有两个常用值：
 * no-cache指浏览器不要缓存当前页面。
 * max-age:xxx指浏览器缓存页面xxx秒。
 *
 * @author liuxl
 * @date 2018/5/18 13:03
 */
public class NoCacheFilter implements Filter {


    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
        //把ServletRequest强转成HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) req;
        //把ServletResponse强转成HttpServletResponse
        HttpServletResponse response = (HttpServletResponse) resp;
        //禁止浏览器缓存所有动态页面
        response.setDateHeader("Expires", -1);
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Pragma", "no-cache");

        chain.doFilter(request, response);
    }

    public void init(FilterConfig filterConfig) throws ServletException {

    }

    public void destroy() {

    }
}