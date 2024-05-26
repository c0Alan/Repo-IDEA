package com.demo.java.web.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet2 extends HttpServlet {
    /* 
     * 处理用户注册的方法
     */
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //1、接收参数
        String userName = request.getParameter("username");
        /**
         * 2、直接跳转回/ELDemo03.jsp页面，没有使用request.setAttribute("userName", userName)将userName存储到request对象中
         * 但是在ELDemo03.jsp页面中可以使用${param.username}获取到request对象中的username参数的值
         */
        request.getRequestDispatcher("/ELDemo03.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}