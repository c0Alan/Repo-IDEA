package com.net.basic.http;

import java.io.*;
import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * http 模拟器
 * 
 * @author liuxilin
 * @date 2018/5/12 17:09
 */
public class HttpSimulator {
    private Socket socket;
    private int port = 80;
    private String host = "localhost";
    private String request = ""; // HTTP请求消息
    private boolean isPost, isHead;

    // 从控制台读取host和port，当输入字符串"q"时，返回false,否则，返回true
    private boolean readHostAndPort(BufferedReader consoleReader)
            throws Exception {
        System.out.print("host:port>");
        String[] ss = null;
        String s = consoleReader.readLine();
        if (s.equals("q"))
            return false;
        else {
            ss = s.split("[:]");
            if (!ss[0].equals(""))
                host = ss[0];
            if (ss.length > 1)
                port = Integer.parseInt(ss[1]);
            System.out.println(host + ":" + String.valueOf(port));
            return true;
        }
    }

    // 从控制台读取HTTP请求消息，并将请求消息保存在request中
    private void readHttpRequest(BufferedReader consoleReader) throws Exception {
        System.out.println("请输入HTTP请求:");
        String s = consoleReader.readLine();
        request = s + "\r\n";
        boolean isPost = s.substring(0, 4).equals("POST");
        boolean isHead = s.substring(0, 4).equals("HEAD");
        while (!(s = consoleReader.readLine()).equals(""))
            request = request + s + "\r\n";
        request = request + "\r\n";
        if (isPost) {
            System.out.println("请输入POST方法的内容:");
            s = consoleReader.readLine();
            request = request + s;
        }
    }

    // 向服务器发送HTTP请求消息
    private void sendHttpRequest() throws Exception {
        socket = new Socket();
        socket.setSoTimeout(10 * 1000);
        System.out.println("正在连接服务器...");
        socket.connect(new InetSocketAddress(host, port), 10 * 1000);
        System.out.println("服务器连接成功！");
        OutputStream out = socket.getOutputStream();
        OutputStreamWriter writer = new OutputStreamWriter(out);
        writer.write(request);
        writer.flush();
    }

    // 读取从服务器返回的HTTP响应消息
    private void readHttpResponse(BufferedReader consoleReader) {
        String s = "";
        try {
            InputStream in = socket.getInputStream();
            InputStreamReader inReader = new InputStreamReader(in);
            BufferedReader socketReader = new BufferedReader(inReader);
            System.out.println("---------HTTP头---------");
            boolean b = true; // true: 未读取消息头 false: 已经读取消息头
            while ((s = socketReader.readLine()) != null) {
                if (s.equals("") && b == true && !isHead) {
                    System.out.println("------------------------");
                    b = false;
                    System.out.print("是否显示HTTP的内容(Y/N):");
                    String choice = consoleReader.readLine();
                    if (choice.equals("Y") || choice.equals("y")) {
                        System.out.println("---------HTTP内容---------");
                        continue;
                    } else
                        break;
                } else
                    System.out.println(s);
            }
        } catch (Exception e) {
            System.out.println("err:" + e.getMessage());
        } finally {
            try {
                socket.close();
            } catch (Exception e) {
            }
        }
        System.out.println("------------------------");
    }

    public void run() throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                if (!readHostAndPort(reader))
                    break;
                readHttpRequest(reader);
                sendHttpRequest();
                readHttpResponse(reader);
            } catch (Exception e) {
                System.out.println("err:" + e.getMessage());
            }
        }
    }

    /**
     * 依次输入:
     * www.baidu.com (www.csdn.net 已经永久性转移, 301状态码)
     * GET / HTTP/1.1
     * Host:www.baidu.com
     * 
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        new HttpSimulator().run();
    }
}