package com.demo.java.net.basic.address;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;

/**
 * DNS服务器访问测试
 *
 * @author liuxl
 * @date 2018/5/10 12:53
 */
public class InetAddressDemo2 {
    private static final Logger logger = Logger.getLogger(InetAddressDemo2.class);

    /**
     * 创建InetAddress对象的三种方式
     * 只有通过使用IP地址创建的InetAddress对象调用getHostName方法时才访问DNS服务器
     *
     * @throws UnknownHostException
     */
    @Test
    public void visitDNS() throws UnknownHostException {
        long time = 0;
        // 1．使用getLocalHost方法创建InetAddress对象, 得到本机名
        InetAddress address1 = InetAddress.getLocalHost();
        System.out.println("本机名： " + address1.getHostName());
        // 2．使用域名创建InetAddress对象, 直接返回域名
        InetAddress address2 = InetAddress.getByName("www.oracle.com");
        time = System.currentTimeMillis();
        System.out.print("直接得到域名： " + address2.getHostName());
        System.out.println("  所用时间："
                + String.valueOf(System.currentTimeMillis() - time) + " 毫秒");
        // 3．使用IP地址创建InetAddress对象, 通过DNS查找域名
        InetAddress address3 = InetAddress.getByName("23.13.187.107");
        System.out.println("address3:  " + address3);  // 域名为空
        time = System.currentTimeMillis();
        System.out.print("通过DNS查找域名： " + address3.getHostName()); // a23-13-187-107.deploy.static.akamaitechnologies.com
        System.out.println("  所用时间：" + String.valueOf(System.currentTimeMillis() - time) + " 毫秒");
        System.out.println("address3:  " + address3);  // 同时输出域名和IP地址
    }

    public void outHostName(InetAddress address, String s) {
        System.out.println("通过" + s + "创建InetAddress对象");
        System.out.println("主 机 名:" + address.getCanonicalHostName());
        System.out.println("主机别名:" + address.getHostName());
        System.out.println("");
    }

    @Test
    public void getCanonicalHostName() throws UnknownHostException {
        outHostName(InetAddress.getLocalHost(), "getLocalHost方法");
        outHostName(InetAddress.getByName("www.ibm.com"), "www.ibm.com");
        outHostName(InetAddress.getByName("www.126.com"), "www.126.com");
        outHostName(InetAddress.getByName("202.108.9.77"), "202.108.9.77");
        outHostName(InetAddress.getByName("211.100.26.121"), "211.100.26.121");
    }

    /**
     * getHostAddress方法, 得到主机的IP地址，这个IP地址可能是IPv4的地址，也可能是IPv6的地址
     * 无论InetAddress对象是使用哪种方式创建的，getHostAddress方法都不会访问DNS服务器
     */
    @Test
    public void getHostAddress() throws UnknownHostException {
        // 输出IPv4地址
        InetAddress ipv4Address1 = InetAddress.getByName("1.2.3.4");
        System.out.println("ipv4Address1: " + ipv4Address1.getHostAddress());
        InetAddress ipv4Address2 = InetAddress.getByName("www.ibm.com");
        System.out.println("ipv4Address2: " + ipv4Address2.getHostAddress());
        InetAddress ipv4Address3 = InetAddress.getByName("USERZGC-5N981IT");
        System.out.println("ipv4Address3: " + ipv4Address3.getHostAddress());
        // 输出IPv6地址
        InetAddress ipv6Address1 = InetAddress.getByName("abcd:123::22ff");
        System.out.println("ipv6Address1: " + ipv6Address1.getHostAddress());
        InetAddress ipv6Address2 = InetAddress.getByName("www.gdut.edu.cn");
        System.out.println("ipv6Address2: " + ipv6Address2.getHostAddress());
        // 输出本机全部的IP地址
        InetAddress Addresses[] = InetAddress.getAllByName("USERZGC-5N981IT");
        for (InetAddress address : Addresses)
            System.out.println("本机地址：" + address.getHostAddress());
    }

    /**
     * 获取ip地址
     * @throws UnknownHostException
     */
    @Test
    public void getAddress() throws UnknownHostException {
        InetAddress address = InetAddress.getByName("www.csdn.net");
        byte ip[] = address.getAddress();
        // 第一行输出了未转换的IP地址，由于www.csdn.net的IP地址的第一个字节大于127，因此，输出了一个负数
        for (byte ipSegment : ip){
            System.out.print(ipSegment + " "); // 47 95 -92 112
        }
        System.out.println("");
        // 将IP地址的每一个字节转换成了int类型
        for (byte ipSegment : ip) {
            int newIPSegment = (ipSegment < 0) ? 256 + ipSegment : ipSegment;
            System.out.print(newIPSegment + " "); // 47 95 164 112
        }
    }

    /**
     * 判断网络地址是否可达
     */
    @Test
    public void isReachable() throws IOException {
        InetAddress ia = InetAddress.getByName("www.baidu.com");
        logger.info(ia.isReachable(1000)); // true

        NetworkInterface eth0 = NetworkInterface.getByName("eth0");
        logger.info(ia.isReachable(eth0, 100, 1000)); // false

        NetworkInterface ppp0 = NetworkInterface.getByName("ppp0");
        logger.info(ia.isReachable(ppp0, 100, 1000)); // false, 本地的网络接口全部不可达
    }


}
