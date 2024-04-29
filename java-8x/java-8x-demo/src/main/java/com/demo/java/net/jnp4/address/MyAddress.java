package com.demo.java.net.jnp4.address;

import java.net.*;

/**
 * 获取本机地址
 */
public class MyAddress {

    public static void main(String[] args) {
        try {
            InetAddress address = InetAddress.getLocalHost(); // USERZGC-***/192.168.*.*
            System.out.println(address);
        } catch (UnknownHostException ex) {
            System.out.println("Could not find this computer's address.");
        }
    }
}
