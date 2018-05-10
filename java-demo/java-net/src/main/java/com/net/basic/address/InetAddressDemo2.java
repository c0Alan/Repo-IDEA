package com.net.basic.address;

import org.junit.Test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * DNS服务器访问测试
 *
 * @author liuxl
 * @date 2018/5/10 12:53
 */
public class InetAddressDemo2 {

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

    public void outHostName(InetAddress address, String s){
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
}
