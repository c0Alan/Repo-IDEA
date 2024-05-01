package com.demo.java.net;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * InetAddress Internet 协议 （IP） 地址
 *
 * @author liuxilin
 * @date 2018/5/10 20:43
 */
public class InetAddressDemo {

    private static final Logger logger = Logger.getLogger(InetAddressDemo.class);

    public static void main(String[] args) {
        InetAddressDemo demo = new InetAddressDemo();
        demo.test01();

    }

    /**
     * 获取网站ip地址
     */
    @Test
    public void test01() {
        try {
            // 获取网站ip地址
            InetAddress address = InetAddress.getByName("www.oreilly.com");
            System.out.println("address: " + address);

            // 获取本机ip地址
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("localHost: " + localHost);
            System.out.println("localHost: " + localHost.getHostAddress());

            // 判断是ipv4还是ipv6
            byte[] localAddress = localHost.getAddress();
            if (localAddress.length == 4) {
                System.out.println("IPv4");
            } else if (localAddress.length == 16) {
                System.out.println("IPv6");
            }

            // 获取域名/主机名
            InetAddress ia = InetAddress.getByName("120.232.145.144");
            System.out.println("主机名: " + ia.getCanonicalHostName());
        } catch (UnknownHostException ex) {
            System.out.println("Could not find www.oreilly.com");
        }
    }
}
