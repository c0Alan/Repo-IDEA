package com.demo.java.web.servlet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用servletContext实现请求转发
 *
 * @author liuxl
 * @date 2024/5/18
 */
public class ServletContextDemo4 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String data = "<h1><font color='red'>abcdefghjkl</font></h1>";
        response.getOutputStream().write(data.getBytes());
        ServletContext context = this.getServletContext();//获取ServletContext对象
        RequestDispatcher rd = context.getRequestDispatcher("/servlet/ServletContextDemo5");//获取请求转发对象(RequestDispatcher)
        rd.forward(request, response);//调用forward方法实现请求转发
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}