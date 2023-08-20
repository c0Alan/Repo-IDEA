package com.jd.java8.juc.collection.map.concurrenthashmap;

import java.util.*;
import java.util.concurrent.*;

/*
 *   ConcurrentHashMap是“线程安全”的哈希表，而HashMap是非线程安全的。
 *
 *   下面是“多个线程同时操作并且遍历map”的示例
 *   (01) 当map是ConcurrentHashMap对象时，程序能正常运行。
 *   (02) 当map是HashMap对象时，程序会产生ConcurrentModificationException异常。
 *
 */
public class ConcurrentHashMapDemo1 {

    // TODO: map是HashMap对象时，程序会出错。
    //private static Map<String, String> map = new HashMap<String, String>();
    private static Map<String, String> map = new ConcurrentHashMap<String, String>();

    public static void main(String[] args) {

        // 同时启动两个线程对map进行操作！
        new MyThread("ta").start();
        new MyThread("tb").start();
    }

    private static void printAll() {
        String key, value;
        Iterator iter = map.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry entry = (Map.Entry) iter.next();
            key = (String) entry.getKey();
            value = (String) entry.getValue();
            System.out.print(key + " - " + value + ", ");
        }
        System.out.println();
    }

    private static class MyThread extends Thread {
        MyThread(String name) {
            super(name);
        }

        @Override
        public void run() {
            int i = 0;
            while (i++ < 6) {
                // “线程名” + "-" + "序号"
                String val = Thread.currentThread().getName() + i;
                map.put(String.valueOf(i), val);
                // 通过“Iterator”遍历map。
                printAll();
            }
        }
    }
}