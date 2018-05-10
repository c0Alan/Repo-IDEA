package com.net.basic.address;

import java.net.InetAddress;

/**
 * DNS 测试类
 *
 * @author liuxilin
 * @date 2018/5/10 7:29
 */
public class DNSDemo {

    /**
     * 通过"networkaddress.cache.ttl", 设置DNS 缓存时间
     * 如果将networkaddress.cache.ttl属性值设为-1，那么DNS缓存数据将永远不会释放。
     *
     * @param dn  访问域名地址
     * @param ttl 缓存时间, -1 时, DNS缓存数据将永远不会释放
     * @throws Exception
     */
    public static void setDNSCache1(String dn, String ttl) throws Exception {
        // args[0]: 本机名 args[1]：缓冲时间
        java.security.Security.setProperty("networkaddress.cache.ttl", ttl);
        long time = System.currentTimeMillis();
        InetAddress addresses1[] = InetAddress.getAllByName(dn);
        System.out.println("addresses1:   "
                + String.valueOf(System.currentTimeMillis() - time)
                + "毫秒");
        for (InetAddress address : addresses1)
            System.out.println(address);
        System.out.print("按任意键继续");
        System.in.read(); // 这里根据不同的停顿时间测试不同的缓存效果
        time = System.currentTimeMillis();
        InetAddress addresses2[] = InetAddress.getAllByName(dn);
        System.out.println("addresses2:   "
                + String.valueOf(System.currentTimeMillis() - time)
                + "毫秒");
        for (InetAddress address : addresses2)
            System.out.println(address);
    }

    /**
     * 通过"networkaddress.cache.negative.ttl", 设置DNS 缓存时间, 默认值是10秒
     *
     * 如果域名在DNS服务器上不存在，那么客户端在进行一段时间的尝试后（平均为5秒），
     * 就会抛出一个UnknownHostException异常。
     * 为了让下一次访问这个域名时不再等待，DNS缓存将这个错误信息也保存了起来。
     *
     * @throws Exception
     */
    public static void setDNSCache2() throws Exception {
        java.security.Security.setProperty("networkaddress.cache.negative.ttl",
                "5");
        long time = 0;
        try {
            time = System.currentTimeMillis();
            InetAddress.getByName("www.ppp123aaa.com");
        } catch (Exception e) {
            System.out.println("www.ppp123aaa.com不存在! address1: "
                    + String.valueOf(System.currentTimeMillis() - time)
                    + "毫秒");
        }
        Thread.sleep(6000); // 5s之内0ms,延迟6秒之后, 1080毫秒
        try {
            time = System.currentTimeMillis();
            InetAddress.getByName("www.ppp123aaa.com");
        } catch (Exception e) {
            System.out.println("www.ppp123aaa.com不存在! address2: "
                    + String.valueOf(System.currentTimeMillis() - time)
                    + "毫秒");
        }
    }

    public static void main(String[] args) throws Exception {
//        setDNSCache1("www.baidu.com", "5"); // 5s 内按键, 0毫秒, 5s 后按键, 1045毫秒
//        setDNSCache1("www.baidu.com", "-1"); // 什么时候按键, 都是0毫秒
//        setDNSCache1("DESKTOP-ODSRILJ", "5"); // 设置访问本机的DNS缓存

        setDNSCache2();
    }

}
