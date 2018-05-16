package com.web.jdbc.dbutils;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Web层的Servlet调用businessService层的业务方法处理用户请求
 * 
 * @author liuxilin
 * @date 2018/5/16 22:30
 */
public class AccountServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AccountService3 service = new AccountService3();
        try {
            service.transfer(1, 2, 100);
        } catch (SQLException e) {
            e.printStackTrace();
            //注意：调用service层的方法出异常之后，继续将异常抛出，这样在TransactionFilter就能捕获到抛出的异常，继而执行事务回滚操作
            throw new RuntimeException(e);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}