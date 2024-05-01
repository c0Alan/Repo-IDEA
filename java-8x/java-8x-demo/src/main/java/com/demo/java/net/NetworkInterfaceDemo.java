package com.demo.java.net;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

/**
 * NetworkInterface 网络接口，得到本机所有的物理网络接口和虚拟机等软件利用本机的物理网络接口创建的逻辑网络接口的信息
 *
 * @author liuxilin
 * @date 2018/5/10 21:54
 */
public class NetworkInterfaceDemo {

    private static final Logger logger = Logger.getLogger(NetworkInterfaceDemo.class);

    public static void main(String[] args) {

    }

    /**
     * 根据名称获取网络接口
     */
    @Test
    public void test02() throws SocketException {
        NetworkInterface interfaces = NetworkInterface.getByName("eth0");
        System.out.println(interfaces);
    }

    /**
     * 列出所有网络接口
     */
    @Test
    public void test01() throws SocketException {
        Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
        while (interfaces.hasMoreElements()) {
            NetworkInterface ni = interfaces.nextElement();
            System.out.println(ni);
        }
    }

}
