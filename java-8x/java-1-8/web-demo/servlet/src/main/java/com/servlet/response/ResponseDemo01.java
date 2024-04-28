package com.servlet.response;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 使用OutputStream流向客户端浏览器输出"中国"这两个汉字
 * 
 * @author liuxilin
 * @date 2018/5/3 23:07
 */
public class ResponseDemo01 extends HttpServlet {

    private static final long serialVersionUID = 4312868947607181532L;

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        outputChineseByOutputStream(response);
        outputChineseByPrintWriter(response);
//        outputOneByOutputStream(response);
//        outputOneByPrintWriter(response);
    }
    
    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * 使用OutputStream流输出中文
     * getBytes()方法如果不带参数，那么就会根据操作系统的语言环境来选择转换码表，
     * 如果是中文操作系统，那么就使用GB2312的码表
     *
     * @param request
     * @param response
     * @throws IOException
     */
    public void outputChineseByOutputStream(HttpServletResponse response) throws IOException{

        String data = "中国";
        OutputStream outputStream = response.getOutputStream();//获取OutputStream输出流
        //通过设置响应头控制浏览器以UTF-8的编码显示数据，如果不加这句话，那么浏览器显示的将是乱码
        response.setHeader("content-type", "text/html;charset=UTF-8");
        byte[] dataByteArr = data.getBytes("UTF-8");//将字符转换成字节数组，指定以UTF-8编码进行转换
        outputStream.write(dataByteArr);//使用OutputStream流向客户端输出字节数组
    }

    /**
     * 使用PrintWriter流输出中文
     * @param request
     * @param response
     * @throws IOException
     */
    public void outputChineseByPrintWriter(HttpServletResponse response) throws IOException{
        String data = "中国";

        response.setCharacterEncoding("UTF-8");//设置将字符以"UTF-8"编码输出到客户端浏览器
        /**
         * PrintWriter out = response.getWriter();
         * 这句代码必须放在response.setCharacterEncoding("UTF-8");之后
         * 否则response.setCharacterEncoding("UTF-8")这行代码的设置将无效，
         * 浏览器显示的时候还是乱码
         */
        PrintWriter out = response.getWriter();//获取PrintWriter输出流
        /**
         * 多学一招：使用HTML语言里面的<meta>标签来控制浏览器行为，
         * 模拟通过设置响应头控制浏览器行为
         * out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
         * 等同于response.setHeader("content-type", "text/html;charset=UTF-8");
         */
        out.write("<meta http-equiv='content-type' content='text/html;charset=UTF-8'/>");
        out.write(data);//使用PrintWriter流向客户端输出字符
    }

    /**
     * 使用OutputStream流输出数字1
     * @param request
     * @param response
     * @throws IOException
     */
    public void outputOneByOutputStream(HttpServletResponse response) throws IOException{
        response.setHeader("content-type", "text/html;charset=UTF-8");
        OutputStream outputStream = response.getOutputStream();
        outputStream.write("使用OutputStream流输出数字1：".getBytes("UTF-8"));
        outputStream.write(1);
//        outputStream.write((1+"").getBytes());
    }

    /**
     * 使用PrintWriter流输出数字1
     * @param request
     * @param response
     * @throws IOException
     */
    public void outputOneByPrintWriter(HttpServletResponse response) throws IOException{
        response.setHeader("content-type", "text/html;charset=UTF-8");
        response.setCharacterEncoding("UTF-8");
        PrintWriter out = response.getWriter();//获取PrintWriter输出流
        out.write("使用PrintWriter流输出数字1：");
        out.write(1+"");
    }

}