package com.demo.java.web.servlet;

import java.io.IOException;
import java.text.MessageFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LogoutServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //移除存储在session中的user对象，实现注销功能
        request.getSession().removeAttribute("user");
        //由于字符串中包含有单引号，在这种情况下使用MessageFormat.format方法拼接字符串时就会有问题
        //MessageFormat.format方法只是把字符串中的单引号去掉，不会将内容填充到指定的占位符中
        String tempStr1 = MessageFormat.format(
                "注销成功！！3秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='3;url={0}'/>",
                request.getContextPath()+"/servlet/LoginUIServlet");
        System.out.println(tempStr1);//输出结果：注销成功！！3秒后为您自动跳到登录页面！！<meta http-equiv=refresh content=3;url={0}/>
        System.out.println("---------------------------------------------------------");
        /**
         * 要想解决"如果要拼接的字符串包含有单引号，那么MessageFormat.format方法就只是把字符串中的单引号去掉，不会将内容填充到指定的占位符中"这个问题，
         * 那么可以需要使用单引号引起来的字符串中使用2个单引号引起来，例如："<meta http-equiv=''refresh'' content=''3;url={0}''/>"
         * 这样MessageFormat.format("<meta http-equiv=''refresh'' content=''3;url={0}''/>","index.jsp")就可以正常返回
         * <meta http-equiv=''refresh'' content=''3;url=index.jsp'/>
         */
        String tempStr2 = MessageFormat.format(
                "注销成功！！3秒后为您自动跳到登录页面！！<meta http-equiv=''refresh'' content=''3;url={0}''/>",
                request.getContextPath()+"/servlet/LoginUIServlet");
        /**
         * 输出结果：
         * 注销成功！！3秒后为您自动跳到登录页面！！
         * <meta http-equiv='refresh' content='3;url=/webmvcframework/servlet/LoginUIServlet'/>
         */
        System.out.println(tempStr2);

        String message = String.format(
                "注销成功！！3秒后为您自动跳到登录页面！！<meta http-equiv='refresh' content='3;url=%s'/>",
                request.getContextPath()+"/servlet/LoginUIServlet");
        request.setAttribute("message",message);
        request.getRequestDispatcher("/message.jsp").forward(request, response);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}