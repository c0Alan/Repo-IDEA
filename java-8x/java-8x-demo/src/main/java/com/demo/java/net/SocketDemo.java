package com.demo.java.net;

import org.junit.Test;

import java.net.*;
import java.io.*;

public class SocketDemo {
    public static void main(String[] args) {
        SocketDemo demo = new SocketDemo();
        demo.test02();

    }


    /**
     * 获得Socket的信息
     */
    @Test
    public void test03() {
        String host = "www.baidu.com";

        try {
            Socket theSocket = new Socket(host, 80);
            System.out.println("Connected to " + theSocket.getInetAddress() + " on port " + theSocket.getPort() + " from port "
                    + theSocket.getLocalPort() + " of " + theSocket.getLocalAddress());
        } catch (UnknownHostException ex) {
            System.err.println("I can't find " + host);
        } catch (SocketException ex) {
            System.err.println("Could not connect to " + host);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     * 查看指定主机上前1024个端口中哪些安装有TCP服务器
     */
    @Test
    public void test02() {

        String host = "www.baidu.com";

        for (int i = 1; i < 1024; i++) {
            try {
                Socket s = new Socket(host, i);
                System.out.println("There is a server on port " + i + " of " + host);
                s.close();
            } catch (UnknownHostException ex) {
                System.err.println(ex);
                break;
            } catch (IOException ex) {
                // must not be a server on this port
            }
        }
    }


    /**
     * Daytime协议客户端
     */
    @Test
    public void test01() {

        String hostname = "time.nist.gov";
        Socket socket = null;
        try {
            socket = new Socket(hostname, 13);
            socket.setSoTimeout(15000);
            InputStream in = socket.getInputStream();
            StringBuilder time = new StringBuilder();
            InputStreamReader reader = new InputStreamReader(in, "ASCII");
            for (int c = reader.read(); c != -1; c = reader.read()) {
                time.append((char) c);
            }
            System.out.println(time);
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException ex) {
                    // ignore
                }
            }
        }
    }
}