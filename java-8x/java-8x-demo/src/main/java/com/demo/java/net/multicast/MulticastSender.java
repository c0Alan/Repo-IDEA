package com.demo.java.net.multicast;

import java.io.*;
import java.net.*;

/**
 * 组播消息发送
 *
 * @author liuxl
 * @date 2024/5/2
 */
public class MulticastSender {

    public static void main(String[] args) {

        InetAddress ia = null;
        int port = 4000;
        String host = "all-systems.mcast.net";
        byte ttl = (byte) 1;

        // read the address from the command line
        try {
            ia = InetAddress.getByName(host);
            if (args.length > 2) {
                ttl = (byte) Integer.parseInt(args[2]);
            }
        } catch (NumberFormatException | IndexOutOfBoundsException
                 | UnknownHostException ex) {
            System.err.println(ex);
            System.err.println("Usage: java MulticastSender multicast_address port ttl");
            System.exit(1);
        }

        byte[] data = "Here's some multicast data\r\n".getBytes();
        DatagramPacket dp = new DatagramPacket(data, data.length, ia, port);

        try (MulticastSocket ms = new MulticastSocket()) {
            ms.setTimeToLive(ttl);
            ms.joinGroup(ia);
            for (int i = 1; i < 10; i++) {
                ms.send(dp);
            }
            ms.leaveGroup(ia);
        } catch (SocketException ex) {
            System.err.println(ex);
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }
}