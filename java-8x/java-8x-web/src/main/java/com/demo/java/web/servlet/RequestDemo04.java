package com.demo.java.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.MessageFormat;
import java.util.Enumeration;
import java.util.Map;

/**
 * 获取客户端通过Form表单提交上来的参数
 *
 * @author liuxl
 * @date 2018/5/4 12:31
 */
public class RequestDemo04 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        /**
         *
         * 对于以get方式传输的数据，request即使设置了以指定的编码接收数据也是无效的，默认的还是使用ISO8859-1这个字符编码来接收数据
         */
        String name = request.getParameter("name");//接收数据
//        name = new String(name.getBytes("ISO8859-1"), "UTF-8");//获取request对象以ISO8859-1字符编码接收到的原始数据的字节数组，然后通过字节数组以指定的编码构建字符串，解决乱码问题
        System.out.println("name：" + name);
    }


    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * 在服务器端使用getParameterNames方法接收表单参数
     *
     * @param request
     */
    public void getParameterNames(HttpServletRequest request) {
        System.out.println("getParameterNames");
        Enumeration<String> paramNames = request.getParameterNames();//获取所有的参数名
        while (paramNames.hasMoreElements()) {
            String name = paramNames.nextElement();//得到参数名
            String value = request.getParameter(name);//通过参数名获取对应的值
            System.out.println(MessageFormat.format("{0}={1}", name, value));
        }
    }

    /**
     * 在服务器端使用getParameterMap方法接收表单参数
     *
     * @param request
     */
    public void getParameterMap(HttpServletRequest request) {
        System.out.println("getParameterMap");
        //request对象封装的参数是以Map的形式存储的
        Map<String, String[]> paramMap = request.getParameterMap();
        for (Map.Entry<String, String[]> entry : paramMap.entrySet()) {
            String paramName = entry.getKey();
            String paramValue = "";
            String[] paramValueArr = entry.getValue();
            for (int i = 0; paramValueArr != null && i < paramValueArr.length; i++) {
                if (i == paramValueArr.length - 1) {
                    paramValue += paramValueArr[i];
                } else {
                    paramValue += paramValueArr[i] + ",";
                }
            }
            System.out.println(MessageFormat.format("{0}={1}", paramName, paramValue));
        }
    }
}