package com.http.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置refresh响应头，让浏览器定时刷新
 * 
 * @author liuxl
 * @date 2018/5/3 12:52
 */
public class ServletDemo04 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * 设置refresh响应头，让浏览器每隔3秒定时刷新
         */
        // response.setHeader("refresh", "3");
        /**
         * 设置refresh响应头，让浏览器3秒后跳转到http://www.baidu.com
         */
        response.setHeader("refresh", "3;url='http://www.baidu.com'");
        response.getWriter().write("gacl");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

}