package com.demo.java.net.jnp4.address;

import java.net.*;

public class ReverseTest {

    /**
     * 根据地址找到主机名
     * @param args
     * @throws UnknownHostException
     */
    public static void main(String[] args) throws UnknownHostException {
        InetAddress ia = InetAddress.getByName("208.201.239.100");
        System.out.println(ia.getCanonicalHostName());
    }
}
