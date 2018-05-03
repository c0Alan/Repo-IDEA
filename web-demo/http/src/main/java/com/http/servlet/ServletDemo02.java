package com.http.servlet;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 1、使用GZIPOutputStream流来压缩数据
 * 2、设置响应头Content-Encoding来告诉浏览器，服务器发送回来的数据压缩后的格式
 * 
 * @author liuxl
 * @date 2018/5/3 12:50
 */
public class ServletDemo02 extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String data = "abcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabc" +
                "dabcdabcdabcdabcdabcdabcdabcdabc" +
                "dabcdabcdabcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabcdab" +
                "cdabcdabcdabcdabcdabcdabcdabcdabcdabcd";
        System.out.println("原始数据的大小为：" + data.getBytes().length);
        
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        GZIPOutputStream gout = new GZIPOutputStream(bout); //buffer
        gout.write(data.getBytes());
        gout.close();
        //得到压缩后的数据
        byte g[] = bout.toByteArray();
        response.setHeader("Content-Encoding", "gzip");
        response.setHeader("Content-Length",g.length +"");
        response.getOutputStream().write(g);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.doGet(request, response);
    }
}