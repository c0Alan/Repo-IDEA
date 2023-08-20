package com.jd.java8.jvm.demo01;

import java.util.ArrayList;

/**
 * 堆溢出, 栈溢出 示例
 *
 * @author liuxilin
 * @date 2018/4/23 21:31
 */
public class RecursionDemo {
    int num = 1;

    /**
     * 测试堆溢出
     * -XX:+HeapDumpOnOutOfMemoryError -Xmx100m
     */
    public void testHeap() throws InterruptedException {
        ArrayList list = new ArrayList(2000);
        for ( ; ; ) {  // 这里会导致内存不断上升，最终达到内存容量上限, 堆溢出
            RecursionDemo demo = new RecursionDemo();
            list.add(demo);
//            System.out.println(list.size());
        }
    }

    /**
     * 测试栈溢出
     */
    public void testStack() {  //无出口的递归调用，栈溢出
        num++;
        this.testStack();
    }

    public void userDir(){
        System.out.println(System.getProperty("user.dir"));
    }


}
