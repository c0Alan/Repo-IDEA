package com.demo.java.web.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 删除cookie时，path必须一致，否则不会删除
 * 
 * @author liuxl
 * @date 2018/5/4 13:20
 */
public class CookieDemo02 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //创建一个名字为lastAccessTime的cookie
        Cookie cookie = new Cookie("lastAccessTime", System.currentTimeMillis()+"");
        //将cookie的有效期设置为0，命令浏览器删除该cookie
        cookie.setMaxAge(0);
        response.addCookie(cookie);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}