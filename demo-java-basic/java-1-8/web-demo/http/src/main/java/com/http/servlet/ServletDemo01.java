package com.http.servlet;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置Location响应头，实现请求重定向
 * 
 * @author liuxl
 * @date 2018/5/3 12:52
 */
public class ServletDemo01 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setStatus(302);//设置服务器的响应状态码
        /**
         *设置响应头，服务器通过 Location这个头，来告诉浏览器跳到哪里，这就是所谓的请求重定向
         */
        response.setHeader("Location", "/demo/1.jsp");
    }
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}