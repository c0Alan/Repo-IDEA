package com.demo.springcloud.servicehi.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

@RestController
public class ServiceHiController {
    @Value("${server.port}")
    String port;


    @RequestMapping("/hi")
    public String hi(@RequestParam(value = "name") String name) {
        String serverIpList = getServerIpList();
        return "hi " + name + " ,i am from " + serverIpList + ":" + port;
    }

    /**
     * 延迟响应
     * @param name
     * @param delayTime
     * @return
     */
    @RequestMapping("/slowHi")
    public String slowHi(@RequestParam(value = "name") String name,
                         @RequestParam(value = "delayTime") Integer delayTime) {
        try {
            Thread.sleep(delayTime * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String serverIpList = getServerIpList();
        return "hi " + name + " ,i am from " + serverIpList + ":" + port;
    }

    public String getServerIpList() {
        List<String> result = new ArrayList<String>();
        try {
            Enumeration<NetworkInterface> netInterfaces;

            netInterfaces = NetworkInterface.getNetworkInterfaces();

            InetAddress ip;
            while (netInterfaces.hasMoreElements()) {
                NetworkInterface ni = netInterfaces.nextElement();
                Enumeration<InetAddress> addresses = ni.getInetAddresses();
                while (addresses.hasMoreElements()) {
                    ip = addresses.nextElement();
                    if (!ip.isLoopbackAddress() && ip.getHostAddress().indexOf(':') == -1) {
                        result.add(ip.getHostAddress());
                    }
                }
            }
        } catch (SocketException e) {
            e.printStackTrace();
        }

        return result.toString();
    }
}
