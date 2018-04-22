package com.collections;

import org.apache.commons.collections4.BidiMap;
import org.apache.commons.collections4.MapIterator;
import org.apache.commons.collections4.bidimap.DualHashBidiMap;
import org.apache.commons.collections4.bidimap.DualTreeBidiMap;
import org.junit.Test;

/**
 * 双向 Map 要求键与值都不能重复
 * BidiMap  inverseBidiMap()
 * 1、DualTreeBidiMap :有序
 * 2、DualHashBidiMap :无序
 *
 * @author liuxilin
 * @date 2018/4/22 23:01
 */
public class BidiMapDemo {

    /**
     * 有序的双向Map, 根据值排序
     */
    @Test
    public void treeMap() {
        BidiMap<String, String> map = new DualTreeBidiMap<String, String>();
        map.put("bj", "bj@test.com");
        map.put("sxt", "yxt@qq.com");
        map.put("abe", "cdf@qq.com");
        //遍历查看
        MapIterator<String, String> it = map.inverseBidiMap().mapIterator();
        while (it.hasNext()) {
            String key = it.next();
            String value = it.getValue();
            System.out.println(key + "-->" + value);
        }
    }

    /**
     * 无序的双向Map, 看起来也是有序的
     */
    @Test
    public void hashMap() {
        BidiMap<String, String> map = new DualHashBidiMap<String, String>();
        map.put("bj", "bj@test.com");
        map.put("sxt", "sxt@qq.com");
        map.put("axt", "axt@qq.com");
        //反转
        System.out.println(map.inverseBidiMap().get("sxt@qq.com"));
        //遍历查看
        MapIterator<String, String> it = map.inverseBidiMap().mapIterator();
        while (it.hasNext()) {
            String key = it.next();
            String value = it.getValue();
            System.out.println(key + "-->" + value);
        }
    }

}