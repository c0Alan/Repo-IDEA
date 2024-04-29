package com.demo.java.net.old.socket.client;

import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class SocketAddressDemo {

    public static void main(String[] args)
    {
        try
        {
            Socket socket1 = new Socket("www.ptpress.com.cn", 80);
            SocketAddress socketAddress = socket1.getRemoteSocketAddress();
            socket1.close();
            Socket socket2 = new Socket();
            // socket2.bind(new InetSocketAddress("192.168.18.252", 0));
            socket2.connect(socketAddress);
            socket2.close();
            InetSocketAddress inetSocketAddress1 = (InetSocketAddress) socketAddress;
            System.out.println("服务器域名:"
                    + inetSocketAddress1.getAddress().getHostName());
            System.out.println("服务器IP:"
                    + inetSocketAddress1.getAddress().getHostAddress());
            System.out.println("服务器端口:" + inetSocketAddress1.getPort());
            InetSocketAddress inetSocketAddress2 = (InetSocketAddress) socket2
                    .getLocalSocketAddress();
            System.out.println("本地IP:"
                    + inetSocketAddress2.getAddress().getLocalHost()
                    .getHostAddress());
            System.out.println("本地端口:" + inetSocketAddress2.getPort());
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
