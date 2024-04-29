package com.demo.java.net.old.socket.client;

import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class SocketDemo04 {
    private void closeSocket(Socket socket) {
        if (socket != null)
            try {
                socket.close();
            } catch (Exception e) {
            }
    }

    /**
     * 测试各种连接的方式
     */
    @Test
    public void connection() {
        Socket socket1 = null, socket2 = null, socket3 = null, socket4 = null;
        try {
            // 如果将www.ptpress.com.cn改成其它不存在的域名，将抛出UnknownHostException错误
            // 测试public Socket(String host, int port)
            socket1 = new Socket("www.ptpress.com.cn", 80);
            System.out.println("socket1连接成功!");

            // 测试public Socket(InetAddress inetaddress, int port)
            socket2 = new Socket(InetAddress.getByName("www.ptpress.com.cn"), 80);
            System.out.println("socket2连接成功!");

            // 下面的两种建立连接的方式并不建议使用
            // 测试public Socket(String host, int port, boolean stream)
            socket3 = new Socket("www.ptpress.com.cn", 80, false);
            System.out.println("socket3连接成功!");

            // 测试public Socket(InetAddress inetaddress, int i, boolean flag)
            socket4 = new Socket(InetAddress.getByName("www.ptpress.com.cn"), 80, false);
            System.out.println("socket4连接成功!");

        } catch (UnknownHostException e) {
            System.out.println("UnknownHostException 被抛出!");
        } catch (IOException e) {
            System.out.println("IOException 被抛出!");
        } finally {
            closeSocket(socket1);
            closeSocket(socket2);
            closeSocket(socket3);
            closeSocket(socket4);
        }
    }

    /**
     * 假设有两台计算机：PC1和PC2。PC1和PC2各有一块网卡。
     * PC1绑定有两个IP：192.168.18.252和200.200.200.200。
     * PC2绑定有一个IP：200.200.200.4。PC1和PC2的子网掩码都是255.255.255.0。
     * 而PC1的默认网关为：192.168.28.254。下面的代码需要在PC1上运行。
     */
    @Test
    public void bindIp()
    {
        try
        {
            InetAddress localAddress1 = InetAddress.getByName("200.200.200.200");
            InetAddress localAddress2 = InetAddress.getByName("192.168.18.252");
            // 如果将localAddress1改成localAddress2，socket1无法连接成功
            Socket socket1 = new Socket("200.200.200.4", 80, localAddress1, 6000);
            System.out.println("socket1连接成功!");
            Socket socket2 = new Socket("www.ptpress.com.cn", 80, localAddress2, 7000);
            System.out.println("socket2连接成功!");
            // 下面的语句将抛出一个IOException错误
            Socket socket3 = new Socket("www.ptpress.com.cn", 80, localAddress1, 6002);
            System.out.println("socket3连接成功!");
            socket1.close();
            socket2.close();
            socket3.close();
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * 通过connect方法连接服务器
     */
    @Test
    public void connect()
    {
        try
        {
            Socket socket1 = new Socket();
            Socket socket2 = new Socket();
            Socket socket3 = new Socket();
            socket1.connect(new InetSocketAddress("200.200.200.4", 80));
            socket1.close();
            System.out.println("socket1连接成功!");
            /*
               将socket2绑定到192.168.18.252将产生一个IOException错误
            socket2.bind(new InetSocketAddress("192.168.18.252", 0));
            */
            socket2.bind(new InetSocketAddress("200.200.200.200", 0));
            socket2.connect(new InetSocketAddress("200.200.200.4", 80));

            socket2.close();
            System.out.println("socket2连接成功!");

            socket3.bind(new InetSocketAddress("192.168.18.252", 0));
            socket3.connect(new InetSocketAddress("200.200.200.4", 80), 2000);
            socket3.close();
            System.out.println("socket3连接成功!");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
