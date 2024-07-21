package com.demo.java.apachecommons.collections;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * 集合操作
 * 1、并集
 * CollectionUtils.union();
 * 2、交集
 * CollectionUtils.intersection();
 * CollectionUtils.retainAll();
 * 3、差集
 * CollectionUtils.subtract();
 *
 * @author Administrator
 */
public class CollectionUtilsDemo {


    @Test
    public void collectionOperation() {
        Set<Integer> set1 = new HashSet<Integer>();
        set1.add(1);
        set1.add(2);
        set1.add(3);

        Set<Integer> set2 = new HashSet<Integer>();
        set2.add(2);
        set2.add(3);
        set2.add(4);

        //并集
        System.out.println("========= 并集 ============");
        Collection<Integer> col = CollectionUtils.union(set1, set2);
        for (Integer temp : col) {
            System.out.println(temp);
        }
        //交集
        System.out.println("========= 交集 ============");
        col = CollectionUtils.retainAll(set1, set2);
        for (Integer temp : col) {
            System.out.println(temp);
        }

        //交集
        System.out.println("========= 交集 ============");
        col =CollectionUtils.intersection(set1, set2);
        for (Integer temp : col) {
            System.out.println(temp);
        }

        //差集 set1 - set2
        System.out.println("========= 差集 set1 - set2============");
        col = CollectionUtils.subtract(set1, set2);
        for (Integer temp : col) {
            System.out.println(temp);
        }

        //差集 set2 - set1
        System.out.println("========= 差集 set2 - set1============");
        col = CollectionUtils.subtract(set2, set1);
        for (Integer temp : col) {
            System.out.println(temp);
        }
    }

}