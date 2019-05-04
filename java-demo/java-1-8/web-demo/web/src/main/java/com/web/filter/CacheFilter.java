package com.web.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 控制浏览器缓存页面中的静态资源
 * 有些动态页面中引用了一些图片或css文件以修饰页面效果，这些图片和css文件经常是不变化的，
 * 所以为减轻服务器的压力，可以使用filter控制浏览器缓存这些文件，以提升服务器的性能。
 * 
 * @author liuxl
 * @date 2018/5/18 13:03
 */
public class CacheFilter implements Filter {

    private FilterConfig filterConfig;

    public void doFilter(ServletRequest req, ServletResponse resp,
                         FilterChain chain) throws IOException, ServletException {
    
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        
        //1.获取用户想访问的资源
        String uri = request.getRequestURI(); 
        
        //2.得到用户想访问的资源的后缀名
        String ext = uri.substring(uri.lastIndexOf(".")+1);
        
        //得到资源需要缓存的时间
        String time = filterConfig.getInitParameter(ext);
        if(time!=null){
            long t = Long.parseLong(time)*3600*1000;
            //设置缓存
            response.setDateHeader("expires", System.currentTimeMillis() + t);
        }
        
        chain.doFilter(request, response);

    }

    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;
    }
    
    public void destroy() {
        
    }
}