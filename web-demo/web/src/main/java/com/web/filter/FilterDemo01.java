package com.web.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * filter的三种典型应用：
 * 1、可以在filter中根据条件决定是否调用chain.doFilter(request, response)方法，即是否让目标资源执行
 * 2、在让目标资源执行之前，可以对request\response作预处理，再让目标资源执行
 * 3、在目标资源执行之后，可以捕获目标资源的执行结果，从而实现一些特殊的功能
 *
 * @author liuxilin
 * @date 2018/5/16 22:39
 */
public class FilterDemo01 implements Filter {

    /**
     * web 应用程序启动时，web 服务器将创建Filter 的实例对象，并调用init方法
     * 通过init方法的参数，可获得代表当前filter配置信息的FilterConfig对象
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("----FilterDemo01 过滤器初始化----");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {

        //对request和response进行一些预处理
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        System.out.println("FilterDemo01执行前！！！");
        chain.doFilter(request, response);  //让目标资源执行，放行
        System.out.println("FilterDemo01执行后！！！");
    }

    @Override
    public void destroy() {
        System.out.println("----FilterDemo01过滤器销毁----");
    }
}