package com.servlet.basic;

import java.io.IOException;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 多个Servlet通过ServletContext对象实现数据共享
 * 
 * @author liuxilin
 * @date 2018/5/3 21:57
 */
public class ServletContextDemo1 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = "xdp_gacl";
        /**
         * ServletConfig对象中维护了ServletContext对象的引用，开发人员在编写servlet时，
         * 可以通过ServletConfig.getServletContext方法获得ServletContext对象。
         */
        ServletContext context = this.getServletConfig().getServletContext();//获得ServletContext对象
        context.setAttribute("data", data);  //将data存储到ServletContext对象中
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}