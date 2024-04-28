package com.demo.java.java8.base.collection.treeSet;

import java.util.*;

/**
 * TreeSet：底层数据结构采用红黑树来实现，元素唯一且已经排好序；
 * 唯一性同样需要重写hashCode和equals()方法，二叉树结构保证了元素的有序性
 *
 * @author liuxilin
 * @date 2022/7/2 14:34
 */
public class TreeSetTest {
    public static void main(String[] args) {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));
        System.out.println(parts);

        NavigableSet<Item> sortByDescription = new TreeSet<>(
                Comparator.comparing(Item::getDescription));

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}