package com.demo.java.apachecommons.net.ip;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.lang3.ArrayUtils;

/**
 * 测试 jdk InetAddress 类
 * 
 * @author liuxl
 * 2017-11-15 下午3:07:20
 */
public class JInetAddress {

    /**
     * （2）：创建InetAddress对象的四个静态方法
     * @throws UnknownHostException
     * @author liuxl
     * @date @time 2017-11-18 上午10:43:00
     */
    public static void chapter02() throws UnknownHostException{
        /** 测试InetAddress对象的四个静态方法 */
        InetAddress localAddress = InetAddress.getLocalHost(); // DESKTOP-ODSRILJ/192.168.12.99
        
        localAddress = InetAddress.getByName("www.baidu.com"); // www.csdn.net/101.201.172.229
        
        InetAddress addresses[] = InetAddress.getAllByName("www.baidu.com"); // {www.baidu.com/183.232.231.172,www.baidu.com/183.232.231.173}
        
        /**
         * IP地址必须是byte数组形式
         * host 只是一个用于表示addr的别名
         */
        byte ip[] = new byte[] { (byte) 141, (byte) 146, 8 , 66};
        InetAddress address1 = InetAddress.getByAddress(ip); // /141.146.8.66
        InetAddress address2 = InetAddress.getByAddress("Oracle官方网站", ip); // Oracle官方网站/141.146.8.66
        System.out.println(address1);
        System.out.println(address2);
    }
}
