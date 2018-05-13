package com.net.basic.socket.server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

class HttpSocket extends Socket {
    /**
     * 获取请求头
     * @return
     * @throws Exception
     */
    public String getRequestHeaders() throws Exception {
        InputStreamReader isr = new InputStreamReader(getInputStream());
        BufferedReader br = new BufferedReader(isr);
        String s = "", result = "";
        while (!(s = br.readLine()).equals(""))
            result = result + s + "\r\n";
        return result;
    }
}

class HttpServerSocket extends ServerSocket {
    public HttpServerSocket(int port) throws IOException {
        super(port);
    }

    public Socket accept() throws IOException  // 覆盖accept方法
    {
        Socket s = new HttpSocket();
        implAccept(s);   // 将accept方法返回的对象类型设为HttpSocket
        return s;
    }
}

/**
 * 定制 Accept 方法
 * 
 * @author liuxilin
 * @date 2018/5/13 10:18
 */
public class CustomAccept {
    /**
     * 浏览器输入http://localhost:1234/
     * 打印请求头
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        HttpServerSocket httpServerSocket = new HttpServerSocket(1234);
        HttpSocket httpSocket = (HttpSocket) httpServerSocket.accept();
        System.out.println(httpSocket.getRequestHeaders()); // 向控制台输出HTTP请求头
        httpServerSocket.close();
    }
}