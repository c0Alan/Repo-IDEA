package com.net.basic.address;


import org.apache.log4j.Logger;
import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * ip 地址测试类
 *
 * @author liuxilin
 * @date 2018/5/9 21:28
 */
public class InetAddressDemo {
    private static final Logger logger = Logger.getLogger(InetAddressDemo.class);

    /**
     * 获取本机地址
     *
     * @throws UnknownHostException
     */
    @Test
    public void getLocalhost() throws UnknownHostException {
        InetAddress localAddress = InetAddress.getLocalHost();
        System.out.println(localAddress); // USERZGC-***/192.168.*.*
    }

    /**
     * 通过指定域名从DNS中得到相应的IP地址
     *
     * @throws UnknownHostException
     */
    @Test
    public void getByName() throws UnknownHostException {
        String host = "www.csdn.net";
        InetAddress address = InetAddress.getByName(host);
        System.out.println(address); // www.csdn.net/47.95.164.112

        host = "USERZGC-5N981IT"; // 你自己的电脑名
        address = InetAddress.getByName(host);
        System.out.println(address); // USERZGC-5N981IT/192.168.*.*

        host = "localhost";
        address = InetAddress.getByName(host);
        System.out.println(address); // localhost/127.0.0.1

        // 在本地IP映射配置文件添加的地址, C:\WINDOWS\system32\drivers\etc, 192.168.18.100 www.mysite.com
        host = "www.mysite.com";
        address = InetAddress.getByName(host);
        System.out.println(address); // www.mysite.com/192.168.18.100
    }

    /**
     * 从DNS上得到域名对应的所有的IP, 方法返回一个InetAddress类型的数组
     * getByName方法返回的IP地址就是getAllByName方法返回的第一个IP地址
     * @throws UnknownHostException
     */
    @Test
    public void getAllByName() throws UnknownHostException {
        String host = "www.csdn.net";
        InetAddress[] addresses = InetAddress.getAllByName(host);
        logger.info(Arrays.asList(addresses)); // [www.csdn.net/47.95.164.112]

        host = "www.baidu.com";
        addresses = InetAddress.getAllByName(host);
        logger.info(Arrays.asList(addresses)); // [www.baidu.com/14.215.177.38, www.baidu.com/14.215.177.39]
    }

    /**
     * 通过IP地址来创建InetAddress对象，IP地址必须是byte数组形式
     * @throws UnknownHostException
     */
    @Test
    public void getByAddress() throws UnknownHostException {
        byte ip[] = new byte[] { (byte) 14, (byte) 215, (byte)177 , (byte)38};
        InetAddress address1 = InetAddress.getByAddress(ip); // /14.215.177.38
        InetAddress address2 = InetAddress.getByAddress("百度ip地址", ip); // 百度ip地址/14.215.177.38
        System.out.println(address1);
        System.out.println(address2);
    }

    /**
     * 判断IP地址版本
     * @throws UnknownHostException
     */
    @Test
    public void getVersion() throws UnknownHostException {
        String host = "www.csdn.net";
        InetAddress address = InetAddress.getByName(host);
        byte[] add = address.getAddress();
        if (add.length == 4) {
            System.out.println("ipv4");
        } else if (add.length == 16) {
            System.out.println("ipv6");
        }
    }
}
