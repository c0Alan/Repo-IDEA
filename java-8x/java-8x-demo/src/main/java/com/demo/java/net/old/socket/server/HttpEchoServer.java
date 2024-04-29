package com.demo.java.net.old.socket.server;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在服务端接收和发送数据
 *
 * @author liuxilin
 * @date 2018/5/12 21:11
 */
public class HttpEchoServer extends Thread {
    private Socket socket;

    @Override
    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(socket
                    .getInputStream());
            BufferedReader br = new BufferedReader(isr);
            OutputStreamWriter osw = new OutputStreamWriter(socket
                    .getOutputStream());
            // 在接收客户端请求后，只向客户端输出了一行HTTP响应头信息（包括响应码和HTTP版本号），
            // 对于HTTP响应头来说，这一行是必须有的，其他的头字段都是可选的。
            osw.write("HTTP/1.1 200 OK\r\n\r\n");
            String s = "";
            while (!(s = br.readLine()).equals("")) // 客户端的请求信息
                osw.write("<html><body>" + s + "<br></body></html>");
            osw.flush();
            socket.close();
        } catch (Exception e) {
        }
    }

    public HttpEchoServer(Socket socket) {
        this.socket = socket;
    }

    /**
     * 浏览器输入 http://localhost:8888/
     * 浏览器显示 客户端的请求信息
     *
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("服务器已经启动，端口：8888");
        while (true) {
            Socket socket = serverSocket.accept();
            new HttpEchoServer(socket).start();
        }
    }
}