package com.jd.java8.base.proxy;

import java.lang.reflect.*;
import java.util.*;

/**
 * 代理示例
 *
 * @author liuxilin
 * @date 2022/6/25 22:37
 */
public class ProxyTest {

    /**
     * 二分法查找关键字
     * @param args
     */
    public static void main(String[] args) {
        Object[] elements = new Object[1000];

        // fill elements with proxies for the integers 1 ... 1000
        for (int i = 0; i < elements.length; i++) {
            Integer value = i + 1;
            InvocationHandler handler = new TraceHandler(value);
            Object proxy = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, handler);
            elements[i] = proxy;
        }

        // construct a random integer
        Integer key = new Random().nextInt(elements.length) + 1;

        // search for the key
        int result = Arrays.binarySearch(elements, key);

        // print match if found
        if (result >= 0) {
           System.out.println(elements[result]);
        }
    }
}


