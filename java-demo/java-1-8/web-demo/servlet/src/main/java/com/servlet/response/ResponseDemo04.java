package com.servlet.response;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ResponseDemo04 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * 1.调用sendRedirect方法实现请求重定向,
         * sendRedirect方法内部调用了
         * response.setHeader("Location", "/JavaWeb_HttpServletResponse_Study_20140615/index.jsp");
         * response.setStatus(HttpServletResponse.SC_FOUND);//设置302状态码，等同于response.setStatus(302);
         */
        response.sendRedirect("/index.jsp");
        
        //2.使用response设置302状态码和设置location响应头实现重定向实现请求重定向
        //response.setHeader("Location", "/JavaWeb_HttpServletResponse_Study_20140615/index.jsp");
        //response.setStatus(HttpServletResponse.SC_FOUND);//设置302状态码，等同于response.setStatus(302);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}