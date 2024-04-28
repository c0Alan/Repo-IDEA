package com.servlet.session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * form表单提交到DoFormServlet进行处理
 * 场景一：在网络延迟的情况下让用户有时间点击多次submit按钮导致表单重复提交
 * 场景二：表单提交后用户点击【刷新】按钮导致表单重复提交
 * 场景三：用户提交表单后，点击浏览器的【后退】按钮回退到表单页面后进行再次提交
 *
 * 利用JavaScript防止表单重复提交, 【场景一】有效，而对于【场景二】和【场景三】是没有用
 * 利用Session防止表单重复提交, 【场景二】和【场景三】导致表单重复提交的问题都有效
 * 
 * @author liuxilin
 * @date 2018/5/4 21:11
 */
public class DoFormServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //客户端是以UTF-8编码传输数据到服务器端的，所以需要设置服务器端以UTF-8的编码进行接收，否则对于中文数据就会产生乱码
        request.setCharacterEncoding("UTF-8");
        String userName = request.getParameter("username");
        try {
            //让当前的线程睡眠3秒钟，模拟网络延迟而导致表单重复提交的现象
            Thread.sleep(3*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("向数据库中插入数据："+userName);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}