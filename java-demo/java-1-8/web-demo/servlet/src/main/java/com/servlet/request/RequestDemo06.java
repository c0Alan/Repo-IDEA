package com.servlet.request;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求RequestDemo06 Servlet，RequestDemo06将请求转发到 request03.jsp 页面
 *
 * @author liuxl
 * @date 2018/5/4 12:35
 */
public class RequestDemo06 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String data="大家好，我正在总结JavaWeb";
        /**
         * 将数据存放到request对象中,此时把request对象当作一个Map容器来使用
         */
        request.setAttribute("data", data);
        request.getRequestDispatcher("/request/request03.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}