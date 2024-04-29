package com.demo.java.net.basic.socket.client;

import org.junit.Test;

import java.net.InetSocketAddress;
import java.net.Socket;

/**
 * 测试socket的各种选项
 * 
 * @author liuxilin
 * @date 2018/5/12 12:51
 */
public class SocketDemo06 {

    /**
     * 测试
     * socket1.getReuseAddress():true
     * error:Address already in use: JVM_Bind
     * socket2.getReuseAddress():true
     * 实际结果, 两次都是: Address already in use: JVM_Bind
     */
    @Test
    public void reuseAddress() {
//    public static void main(String[] args){
        Socket socket1 = new Socket();
        Socket socket2 = new Socket();
        try {
            socket1.setReuseAddress(true);
            socket1.bind(new InetSocketAddress("127.0.0.1", 88));
            System.out.println("socket1.getReuseAddress():"
                    + socket1.getReuseAddress());
            socket2.bind(new InetSocketAddress("127.0.0.1", 88));
        } catch (Exception e) {
            System.out.println("error:" + e.getMessage());
            try {
                socket2.setReuseAddress(true);
                socket2.bind(new InetSocketAddress("127.0.0.1", 88));
                System.out.println("socket2.getReuseAddress():"
                        + socket2.getReuseAddress());
                System.out.println("端口88第二次绑定成功!");
            } catch (Exception e1) {
                System.out.println(e.getMessage());
            }
        }
    }
}
