package com.demo.java.web.servlet.dulsubmit;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * token 的方式防止表达重复提交
 * 创建FormServlet，用于生成Token(令牌)和跳转到form.jsp页面
 * 
 * @author liuxilin
 * @date 2018/5/4 21:36
 */
public class FormServlet extends HttpServlet {
    private static final long serialVersionUID = -884689940866074733L;

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String token = TokenProccessor.getInstance().makeToken();//创建令牌
        System.out.println("在FormServlet中生成的token："+token);
        request.getSession().setAttribute("token", token);  //在服务器使用session保存token(令牌)
        request.getRequestDispatcher("/session/form.jsp").forward(request, response);//跳转到form.jsp页面
    }

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}