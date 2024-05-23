package com.demo.java.web.servlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 通过request对象获取客户端请求头信息
 * 
 * @author liuxl
 * @date 2018/5/4 12:35
 */
public class RequestDemo02 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");//设置将字符以"UTF-8"编码输出到客户端浏览器
        //通过设置响应头控制浏览器以UTF-8的编码显示数据
        response.setHeader("content-type", "text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        Enumeration<String> reqHeadInfos = request.getHeaderNames();//获取所有的请求头
        out.write("获取到的客户端所有的请求头信息如下：");
        out.write("<hr/>");
        while (reqHeadInfos.hasMoreElements()) {
            String headName = (String) reqHeadInfos.nextElement();
            String headValue = request.getHeader(headName);//根据请求头的名字获取对应的请求头的值
            out.write(headName+":"+headValue);
            out.write("<br/>");
        }
        out.write("<br/>");
        out.write("获取到的客户端Accept-Encoding请求头的值：");
        out.write("<hr/>");
        String value = request.getHeader("Accept-Encoding");//获取Accept-Encoding请求头对应的值
        out.write(value);
        
        Enumeration<String> e = request.getHeaders("Accept-Encoding");
        while (e.hasMoreElements()) {
            String string = (String) e.nextElement();
            System.out.println(string);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}