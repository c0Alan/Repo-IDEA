package com.demo.java.web.controller;

import com.demo.java.web.annotation.WebInitParam;
import com.demo.java.web.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

/**
 * 通过自定义 @WebServlet 注解，模拟实现 Servlet 的功能, 通过 AnnotationHandleFilter 解析注解
 * 通过 /WebServletLogin.jsp 登录访问
 *
 * @ClassName: LoginServlet
 * @Description:处理用户登录的Servlet， LoginServlet现在就是一个普通的java类，不是一个真正的Servlet
 */
//将开发好的WebServlet注解标注到LoginServlet类上
@WebServlet(
        //Servlet的访问URL
        value = "/servlet/LoginServlet",
        //Servlet的访问URL，可以使用数组的方式配置多个访问路径
        urlPatterns = {"/gacl/LoginServlet", "/xdp/LoginServlet"},
        //Servlet的初始化参数
        initParams = {
                @WebInitParam(paramName = "gacl", paramValue = "孤傲苍狼"),
                @WebInitParam(paramName = "bhsh", paramValue = "白虎神皇")
        },
        name = "LoginServlet",
        description = "处理用户登录的Servlet"
)
public class LoginServlet {

    /**
     * !loginHandle.do 指定执行 loginHandle 方法
     * /servlet/LoginServlet!loginHandle.do?usename=gacl&pwd=xdp
     * /gacl/LoginServlet!loginHandle.do?usename=gacl&pwd=xdp
     * /xdp/LoginServlet!loginHandle.do?usename=gacl&pwd=xdp
     */
    public void loginHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("usename");
        String pwd = request.getParameter("pwd");
        if (username.equals("gacl") && pwd.equals("xdp")) {
            request.getSession().setAttribute("usename", username);
            request.setAttribute("msg", "欢迎您！" + username);
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        } else {
            request.setAttribute("msg", "登录失败，请检查用户名和密码是否正确！");
            request.getRequestDispatcher("/WebServletLogin.jsp").forward(request, response);
        }
    }


    /**
     * @Method: init
     * @Description: Servlet初始化
     * @Anthor:孤傲苍狼
     */
    public void init(Map<String, String> initParamMap) {
        System.out.println("--LoginServlet初始化--");
        System.out.println(initParamMap.get("gacl"));
        System.out.println(initParamMap.get("bhsh"));
    }
}