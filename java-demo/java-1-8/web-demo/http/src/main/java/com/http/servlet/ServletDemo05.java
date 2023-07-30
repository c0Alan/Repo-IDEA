package com.http.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 设置content-disposition响应头，让浏览器下载文件
 *
 * @author liuxl
 * @date 2018/5/3 12:51
 */
public class ServletDemo05 extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         * 设置content-disposition响应头，让浏览器下载文件
         */
        response.setHeader("content-disposition", "attachment;filename=xxx.jpg");
        InputStream in = this.getServletContext().getResourceAsStream("/img/img1.png");
        byte buffer[] = new byte[1024];
        int len = 0;
        OutputStream out = response.getOutputStream();
        while ((len = in.read(buffer)) > 0) {
            out.write(buffer, 0, len);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }

}