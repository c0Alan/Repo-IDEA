package com.demo.java.net.basic.address;

import org.apache.log4j.Logger;
import org.junit.Test;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Collections;
import java.util.Enumeration;

/**
 * 得到本机所有的物理网络接口和虚拟机等软件利用本机的物理网络接口创建的逻辑网络接口的信息
 *
 * @author liuxilin
 * @date 2018/5/10 21:54
 */
public class NetworkInterfaceDemo {

    private static final Logger logger = Logger.getLogger(NetworkInterfaceDemo.class);

    /**
     * 根据网络接口名getByName创建 NetworkInterface 对象
     *
     * @throws SocketException
     */
    @Test
    public void getByName() throws SocketException {
        NetworkInterface ni = NetworkInterface.getByName("net3");
        System.out.println((ni == null) ? "网络接口不存在!" : ni);

        ni = NetworkInterface.getByName("ppp0");
        System.out.println((ni == null) ? "网络接口不存在!" : ni);
    }

    /**
     * 根据IP地址getByInetAddress创建 NetworkInterface 对象
     *
     * @throws SocketException
     */
    @Test
    public void getByInetAddress() throws Exception {
        InetAddress local = InetAddress.getByName("127.0.0.1");
        NetworkInterface ni = NetworkInterface.getByInetAddress(local);
        System.out.println((ni == null) ? "网络接口不存在!" : ni); // name:lo (Software Loopback Interface 1)

        local = InetAddress.getByName("192.168.6.1");
        ni = NetworkInterface.getByInetAddress(local);
        System.out.println((ni == null) ? "网络接口不存在!" : ni); // name:eth4 (VMware Virtual Ethernet Adapter for VMnet1)
    }

    /**
     * 得到本机所有的网络接口
     */
    @Test
    public void getNetworkInterfaces() throws SocketException {
        Enumeration<NetworkInterface> nis = NetworkInterface.getNetworkInterfaces();
        while (nis.hasMoreElements()){
            logger.info(nis.nextElement());
            logger.info("Name: " + nis.nextElement().getName());
            logger.info("DisplayName: " + nis.nextElement().getDisplayName());
            logger.info(Collections.list(nis.nextElement().getInetAddresses()));
        }

    }
}
