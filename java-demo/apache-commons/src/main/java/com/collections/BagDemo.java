package com.collections;

import org.apache.commons.collections4.Bag;
import org.apache.commons.collections4.bag.HashBag;
import org.apache.commons.collections4.bag.TreeBag;

import java.util.Iterator;
import java.util.Set;

/**
 * Bag 包允许重复
 * 1、HashBag 无序
 * 2、TreeBag 有序
 * 统计单词的出现次数
 *
 * @author liuxilin
 * @date 2018/4/22 23:14
 */
public class BagDemo {

    /**
     * @param args
     */
    public static void main(String[] args) {
        //hashBag();
        //treeBag();
        String str = "this is a cat and that is a mice where is the food";
        //分割字符串
        String[] strArray = str.split(" ");
        Bag<String> bag = new TreeBag<String>();
        for (String temp : strArray) {
            bag.add(temp);
        }

        System.out.println("====统计次数===");
        Set<String> keys = bag.uniqueSet();
        for (String letter : keys) {
            System.out.println(letter + "-->" + bag.getCount(letter));
        }

    }

    /**
     * 有序
     */
    public static void treeBag() {
        System.out.println("=====有序的包====");
        Bag<String> bag = new TreeBag<String>();
        bag.add("a");
        bag.add("a", 5);
        bag.remove("a", 2);
        bag.add("b");
        bag.add("c");
        Iterator<String> it = bag.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    /**
     * 无序
     */
    public static void hashBag() {
        System.out.println("=====无序的包====");
        Bag<String> bag = new HashBag<String>();
        bag.add("a");
        bag.add("a", 5);
        bag.remove("a", 2);
        bag.add("b");
        bag.add("c");
        Iterator<String> it = bag.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

}