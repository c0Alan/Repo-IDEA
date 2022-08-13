package com.demo.springcloud.java8.base.collection.set;

import java.util.*;

/**
 * HashSet：底层数据结构采用哈希表实现，元素无序且唯一，线程不安全，效率高，可以存储null元素
 * 元素的唯一性是靠所存储元素类型是否重写hashCode()和equals()方法来保证的，如果没有重写这两个方法，则无法保证元素的唯一性
 *
 * @author liuxilin
 * @date 2022/7/2 14:13
 */
public class SetTest {
    public static void main(String[] args) {
        // HashSet implements Set
        Set<String> words = new HashSet<>();
        long totalTime = 0;

        try (Scanner in = new Scanner(System.in)) {
            while (in.hasNext()) {
                String word = in.next();
                long callTime = System.currentTimeMillis();
                words.add(word);
                callTime = System.currentTimeMillis() - callTime;
                totalTime += callTime;
            }
        }

        Iterator<String> iter = words.iterator();
        for (int i = 1; i <= 20 && iter.hasNext(); i++) {
           System.out.println(iter.next());
        }
        System.out.println(". . .");
        System.out.println(words.size() + " distinct words. " + totalTime + " milliseconds.");
    }
}
