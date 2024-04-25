package com.demo.java.jmh;

import com.google.common.base.Stopwatch;
import com.google.common.base.Strings;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * JMH必知必会
 * 参考：https://blog.csdn.net/u014282578/article/details/127952593
 */
public class JmhApp {
    /**
     * 测试数据
     */
    private final static String DATA = "大白有点菜";
    /**
     * add操作次数
     */
    private final static int ADD_COUNT = 1000000;
    /**
     * 迭代（循环）次数
     */
    private final static int MAX_ITERATIONS = 10;

    /**
     * 测试方法
     *
     * @param list
     */
    private static void test(List<String> list) {
        for (int i = 0; i < ADD_COUNT; i++) {
            list.add(DATA);
        }
    }

    /**
     * ArrayList性能测试
     *
     * @param iterations 迭代（循环）次数
     */
    private static void arrayListPerfTest(int iterations) {
        for (int i = 0; i < iterations; i++) {
            final List<String> list = new ArrayList<>();
            final Stopwatch stopwatch = Stopwatch.createStarted();
            test(list);
            System.out.println(new StringBuilder().append("ArrayList第 ").append(i + 1)
                    .append(" 次循环add操作").append(ADD_COUNT).append("次耗费时间为：")
                    .append(stopwatch.stop().elapsed(TimeUnit.MILLISECONDS)).append("毫秒"));
        }
    }

    /**
     * LinkedList性能测试
     *
     * @param iterations 迭代（循环）次数
     */
    private static void linkedListPerfTest(int iterations) {
        for (int i = 0; i < iterations; i++) {
            final List<String> list = new LinkedList<>();
            final Stopwatch stopwatch = Stopwatch.createStarted();
            test(list);
            System.out.println(new StringBuilder().append("LinkedList第 ").append(i + 1)
                    .append(" 次循环add操作").append(ADD_COUNT).append("次耗费时间为：")
                    .append(stopwatch.stop().elapsed(TimeUnit.MILLISECONDS)).append("毫秒"));
        }
    }


    public static void main(String[] args) {
        arrayListPerfTest(MAX_ITERATIONS);
        System.out.println(Strings.repeat("#", 48));
        linkedListPerfTest(MAX_ITERATIONS);
    }
}
