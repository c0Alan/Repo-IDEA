package com.demo.java.net.multicast;

import java.io.*;
import java.net.*;

/**
 * 组播消息监听
 *
 * @author liuxl
 * @date 2024/5/2
 */
public class MulticastSniffer {

    public static void main(String[] args) {

        InetAddress group = null;

        // 一个全球即插即用(Universal Plug and Play, UPnP) 设备加入网络时，它会向组播地址239.255.255.250的端口1900发送一个HTTPU (HTTP over UDP)消息。
        // 可以使用这个程序监听那些消息
        /*int port = 1900;
        String host = "239.255.255.250";*/

        int port = 4000;
        String host = "all-systems.mcast.net";

        // read the address from the command line
        try {
            group = InetAddress.getByName(host);
        } catch (ArrayIndexOutOfBoundsException | NumberFormatException | UnknownHostException ex) {
            System.err.println("Usage: java MulticastSniffer multicast_address port");
            System.exit(1);
        }

        MulticastSocket ms = null;
        try {
            ms = new MulticastSocket(port);
            ms.joinGroup(group);

            byte[] buffer = new byte[8192];
            while (true) {
                DatagramPacket dp = new DatagramPacket(buffer, buffer.length);
                ms.receive(dp);
                String s = new String(dp.getData(), "8859_1");
                System.out.println(s);
            }
        } catch (IOException ex) {
            System.err.println(ex);
        } finally {
            if (ms != null) {
                try {
                    ms.leaveGroup(group);
                    ms.close();
                } catch (IOException ex) {
                }
            }
        }
    }
}