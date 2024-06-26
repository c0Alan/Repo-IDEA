package com.demo.java.juc.collection;

import java.util.*;
import java.util.concurrent.*;

/**
 * ConcurrentSkipListSet是“线程安全”的集合，而TreeSet是非线程安全的。
 * <p>
 * 下面是“多个线程同时操作并且遍历集合set”的示例
 * (01) 当set是ConcurrentSkipListSet对象时，程序能正常运行。
 * (02) 当set是TreeSet对象时，程序会产生ConcurrentModificationException异常。
 */
public class ConcurrentSkipListSetDemo {

    // TODO: set是TreeSet对象时，程序会出错。
    //private static Set<String> set = new TreeSet<String>();
    private static Set<String> set = new ConcurrentSkipListSet<String>();

    public static void main(String[] args) {

        test01();
    }

    public static void test01() {

        // 同时启动两个线程对set进行操作！
        new MyThread("ta").start();
        new MyThread("tb").start();
    }

    private static void printAll() {
        /*String value = null;
        Iterator iter = set.iterator();
        while (iter.hasNext()) {
            value = (String) iter.next();
            System.out.print(value + ", ");
        }
        System.out.println();*/
        System.out.println(Thread.currentThread().getName() + "-" + set);
    }

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i = 0;
            while (i++ < 10) {
                // “线程名” + "序号"
                String val = Thread.currentThread().getName() + (i % 6);
                set.add(val);
                // 通过“Iterator”遍历set。
                printAll();
            }
        }
    }
}