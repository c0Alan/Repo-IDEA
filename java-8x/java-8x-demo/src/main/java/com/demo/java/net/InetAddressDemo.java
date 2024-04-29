package com.demo.java.net;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.UnknownHostException;
import java.util.Arrays;

/**
 * InetAddress Internet 协议 （IP） 地址
 *
 * @author liuxilin
 * @date 2018/5/10 20:43
 */
public class InetAddressDemo {

    private static final Logger logger = Logger.getLogger(InetAddressDemo.class);


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

    public static void main(String[] args) throws Exception {
        InetAddressDemo demo = new InetAddressDemo();
        demo.setDNSCache1();
    }

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

    /**
     * 通过"networkaddress.cache.ttl", 设置DNS 缓存时间
     * 如果将networkaddress.cache.ttl属性值设为-1，那么DNS缓存数据将永远不会释放。
     * <p>
     * setDNSCache1("www.baidu.com", "5"); // 5s 内按键, 0毫秒, 5s 后按键, 1045毫秒
     * setDNSCache1("www.baidu.com", "-1"); // 什么时候按键, 都是0毫秒
     * setDNSCache1("DESKTOP-ODSRILJ", "5"); // 设置访问本机的DNS缓存
     *
     */
    @Test
    public void setDNSCache1() throws Exception {
        String dn = "www.baidu.com";
        String ttl = "5";

        // args[0]: 本机名 args[1]：缓冲时间
        java.security.Security.setProperty("networkaddress.cache.ttl", ttl);
        long time = System.currentTimeMillis();
        InetAddress addresses1[] = InetAddress.getAllByName(dn);
        System.out.println("addresses1:   " + String.valueOf(System.currentTimeMillis() - time) + "毫秒");
        for (InetAddress address : addresses1) {
            System.out.println(address);
        }
        System.out.print("按任意键继续");
        System.in.read(); // 这里根据不同的停顿时间测试不同的缓存效果
        time = System.currentTimeMillis();
        InetAddress addresses2[] = InetAddress.getAllByName(dn);
        System.out.println("addresses2:   " + String.valueOf(System.currentTimeMillis() - time) + "毫秒");
        for (InetAddress address : addresses2) {
            System.out.println(address);
        }
    }

    /**
     * 通过"networkaddress.cache.negative.ttl", 设置DNS 缓存时间, 默认值是10秒
     * <p>
     * 如果域名在DNS服务器上不存在，那么客户端在进行一段时间的尝试后（平均为5秒），
     * 就会抛出一个UnknownHostException异常。
     * 为了让下一次访问这个域名时不再等待，DNS缓存将这个错误信息也保存了起来。
     *
     * @throws Exception
     */
    @Test
    public void setDNSCache2() throws Exception {
        java.security.Security.setProperty("networkaddress.cache.negative.ttl", "5");
        long time = 0;
        try {
            time = System.currentTimeMillis();
            InetAddress.getByName("www.ppp123aaa.com");
        } catch (Exception e) {
            System.out.println("www.ppp123aaa.com不存在! address1: " + String.valueOf(System.currentTimeMillis() - time) + "毫秒");
        }
        Thread.sleep(6000); // 5s之内0ms,延迟6秒之后, 1080毫秒
        try {
            time = System.currentTimeMillis();
            InetAddress.getByName("www.ppp123aaa.com");
        } catch (Exception e) {
            System.out.println("www.ppp123aaa.com不存在! address2: " + String.valueOf(System.currentTimeMillis() - time) + "毫秒");
        }
    }

    /**
     * 判断一个IP地址是否在上述十种特殊地址类型的范围内,
     * 如果未输出任何结果，说明指定的IP地址并不属性上述的十种IP地址类型的范围，只是一个普通的IP地址
     *
     * @throws Exception
     */
    @Test
    public void isSpecialType() throws Exception {
        InetAddress address = InetAddress.getByName("224.0.0.1");
        Method methods[] = InetAddress.class.getMethods();
        // 以is开头并且没有参数的方法
        // isMCLinkLocal = true, isMulticastAddress = true
        for (Method method : methods) {
            if (method.getName().matches("is.*") && method.getParameterTypes().length == 0) {
                if (Boolean.parseBoolean(method.invoke(address).toString())) {
                    System.out.println(method.getName() + " = true");
                }
            }
        }
    }

    /**
     * 测试IP地址性质
     */
    @Test
    public void ipTest() {
        String ip = "127.0.0.1";

        try {
            InetAddress address = InetAddress.getByName(ip);

            if (address.isAnyLocalAddress()) {
                System.out.println(address + " is a wildcard address.");
            }
            if (address.isLoopbackAddress()) {
                System.out.println(address + " is loopback address.");
            }

            if (address.isLinkLocalAddress()) {
                System.out.println(address + " is a link-local address.");
            } else if (address.isSiteLocalAddress()) {
                System.out.println(address + " is a site-local address.");
            } else {
                System.out.println(address + " is a global address.");
            }

            if (address.isMulticastAddress()) {
                if (address.isMCGlobal()) {
                    System.out.println(address + " is a global multicast address.");
                } else if (address.isMCOrgLocal()) {
                    System.out.println(address
                            + " is an organization wide multicast address.");
                } else if (address.isMCSiteLocal()) {
                    System.out.println(address + " is a site wide multicast address.");
                } else if (address.isMCLinkLocal()) {
                    System.out.println(address + " is a subnet wide multicast address.");
                } else if (address.isMCNodeLocal()) {
                    System.out.println(address
                            + " is an interface-local multicast address.");
                } else {
                    System.out.println(address + " is an unknown multicast address type.");
                }
            } else {
                System.out.println(address + " is a unicast address.");
            }
        } catch (UnknownHostException ex) {
            ex.printStackTrace();
        }
    }
}
