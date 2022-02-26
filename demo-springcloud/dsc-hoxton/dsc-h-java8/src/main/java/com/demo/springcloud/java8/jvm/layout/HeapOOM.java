package com.demo.springcloud.java8.jvm.layout;

import java.util.ArrayList;
import java.util.List;

/**
 * java 堆溢出
 * OutOfMemoryError 异常测试
 * 一般由于创建过多的对象导致
 * VM Args：-Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 
 * @author liuxilin
 * @date 2018/5/26 9:20
 */
public class HeapOOM {

    static class OOMObject {
    }

    public static void main(String[] args) {
        System.out.println(System.getProperty("user.dir"));
        List<OOMObject> list = new ArrayList<OOMObject>();

        while (true) {
            list.add(new OOMObject());
        }
    }
}
