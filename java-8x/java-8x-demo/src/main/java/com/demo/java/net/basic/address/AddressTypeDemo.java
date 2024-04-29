package com.demo.java.net.basic.address;

import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * isXxx方法判断地址类型
 *
 * @author liuxilin
 * @date 2018/5/10 20:43
 */
public class AddressTypeDemo {

    /**
     * 判断一个IP地址是否在上述十种特殊地址类型的范围内,
     *  如果未输出任何结果，说明指定的IP地址并不属性上述的十种IP地址类型的范围，只是一个普通的IP地址
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
                if (Boolean.parseBoolean(method.invoke(address).toString()))
                    System.out.println(method.getName() + " = true");
            }
        }
    }
}
