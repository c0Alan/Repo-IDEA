package com.demo.java.collection;

import com.demo.java.entity.Item;
import com.demo.java.entity.Child;
import com.demo.java.entity.Parent;
import org.junit.Test;

import java.util.Comparator;
import java.util.NavigableSet;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * TreeSet 里面放对象, 如果同时放入了父类和子类的实例对象,
 * 那比较时使用的是父类的compareTo 方法, 还是使用的子类的compareTo 方法, 还是抛异常！
 * 当前的add方法放入的是哪个对象, 就调用哪个对象的compareTo方法
 *
 * @author liuxl
 * @date 2018/6/8 12:35
 */
public class TreeSetDemo {

    public static void main(String[] args) {
        TreeSet set = new TreeSet();
        set.add(new Parent(3));
        set.add(new Child());
        set.add(new Parent(4));
        System.out.println(set.size());
    }

    /**
     * TreeSet：底层数据结构采用红黑树来实现，元素唯一且已经排好序；
     * 唯一性同样需要重写hashCode和equals()方法，二叉树结构保证了元素的有序性
     */
    @Test
    public void test01() {
        SortedSet<Item> parts = new TreeSet<>();
        parts.add(new Item("Toaster", 1234));
        parts.add(new Item("Widget", 4562));
        parts.add(new Item("Modem", 9912));
        System.out.println(parts);

        NavigableSet<Item> sortByDescription = new TreeSet<>(Comparator.comparing(Item::getDescription));

        sortByDescription.addAll(parts);
        System.out.println(sortByDescription);
    }
}