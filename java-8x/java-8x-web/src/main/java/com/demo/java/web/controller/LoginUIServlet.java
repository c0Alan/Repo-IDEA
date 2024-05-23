package com.demo.java.web.controller;

import com.demo.java.web.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 通过自定义 @WebServlet 注解，模拟实现 Servlet 的功能, 通过 AnnotationHandleFilter 解析注解
 *
 * @author liuxl
 * @date 2024/5/23
 */
@WebServlet("/servlet/LoginUI")
public class LoginUIServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        request.getRequestDispatcher("/WebServletLogin.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}