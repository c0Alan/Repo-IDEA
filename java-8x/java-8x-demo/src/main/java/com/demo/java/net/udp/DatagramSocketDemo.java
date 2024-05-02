package com.demo.java.net.udp;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * DatagramSocket UDP 协议客户端或服务端
 *
 * @author liuxl
 * @date 2024/5/1
 */
public class DatagramSocketDemo {

    private final static Logger audit = Logger.getLogger("requests");
    private final static Logger errors = Logger.getLogger("errors");

    public static void main(String[] args) {
        DatagramSocketDemo demo = new DatagramSocketDemo();
        demo.server02client01();

    }


    /**
     * 多线程服务端实现打印客户端发送的消息
     * nc -u localhost 9 命令进行连接
     */
    @Test
    public void server03() {
        DatagramSocketUDPServer server = new DatagramSocketUDPDiscardServer();
        Thread t = new Thread(server);
        t.start();
    }

    /**
     * 服务端02的客户端示例，打印客户端发送的消息
     *
     * @Test 方式无法在窗口输入内容
     */
    @Test
    public void server02client01() {

        String hostname = "localhost";
        int PORT = 9;

        try (DatagramSocket theSocket = new DatagramSocket()) {
            InetAddress server = InetAddress.getByName(hostname);
            BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
            while (true) {
                String theLine = userInput.readLine();
                if (theLine.equals(".")) {
                    break;
                }
                byte[] data = theLine.getBytes();
                DatagramPacket theOutput = new DatagramPacket(data, data.length, server, PORT);
                theSocket.send(theOutput);
            } // end while
        } catch (IOException ex) {
            System.err.println(ex);
        }
    }

    /**
     * 服务端02示例，打印客户端发送的消息
     */
    @Test
    public void server02() {
        int PORT = 9;
        int MAX_PACKET_SIZE = 65507;

        byte[] buffer = new byte[MAX_PACKET_SIZE];

        try (DatagramSocket server = new DatagramSocket(PORT)) {
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
            while (true) {
                try {
                    server.receive(packet);
                    String s = new String(packet.getData(), 0, packet.getLength(), "8859_1");
                    System.out.println(packet.getAddress() + " at port " + packet.getPort() + " says " + s);
                    // reset the length for the next packet
                    packet.setLength(buffer.length);
                } catch (IOException ex) {
                    System.err.println(ex);
                }
            } // end while
        } catch (SocketException ex) {
            System.err.println(ex);
        }
    }


    /**
     * 服务端01的客户端示例
     */
    @Test
    public void server01client01() {
        int PORT = 13;
//        String HOSTNAME = "time.nist.gov";
        String HOSTNAME = "localhost";
        try (DatagramSocket socket = new DatagramSocket(0)) {
            socket.setSoTimeout(10000);
            InetAddress host = InetAddress.getByName(HOSTNAME);
            DatagramPacket request = new DatagramPacket(new byte[1], 1, host, PORT);
            DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
            socket.send(request);
            socket.receive(response);
            String result = new String(response.getData(), 0, response.getLength(), "US-ASCII");
            System.out.println(result);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 服务端01示例，给客户端推送当前日期
     */
    @Test
    public void server01() {
        int PORT = 13;
        try (DatagramSocket socket = new DatagramSocket(PORT)) {
            while (true) {
                try {
                    DatagramPacket request = new DatagramPacket(new byte[1024], 1024);
                    socket.receive(request);

                    String daytime = new Date().toString();
                    byte[] data = daytime.getBytes("US-ASCII");
                    DatagramPacket response = new DatagramPacket(data, data.length, request.getAddress(), request.getPort());
                    socket.send(response);
                    audit.info(daytime + " " + request.getAddress());
                } catch (IOException | RuntimeException ex) {
                    errors.log(Level.SEVERE, ex.getMessage(), ex);
                }
            }
        } catch (IOException ex) {
            errors.log(Level.SEVERE, ex.getMessage(), ex);
        }
    }
}