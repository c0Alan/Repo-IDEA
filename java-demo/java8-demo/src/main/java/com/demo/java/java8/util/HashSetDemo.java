package com.demo.java.java8.util;

import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.json.JSONUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author liuxilin
 * @date 2022年05月19日 22:52
 */
@Slf4j
public class HashSetDemo {
    public static void main(String[] args) {
        demo02();
    }

    /**
     * hashset 合并
     */
    public static void demo02(){
        Map m = new HashMap();
        Set<String> set = new HashSet();
        Set<String> set2 = new HashSet();
        set.add("aaa");
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");

        set2.add("ddd");
        set2.add("eee");
        set2.add("eee");
        set2.add("fff");

        Set union = CollectionUtil.unionDistinct(set, set2);

        m.put("set", union);
        log.info("运行结果: {}", JSONUtil.toJsonStr(m));
    }

    /**
     * 打印hashset jsonstring 内容
     */
    public static void demo01(){
        Map m = new HashMap();
        Set<String> set = new HashSet();
        set.add("aaa");
        set.add("aaa");
        set.add("bbb");
        set.add("ccc");

        m.put("set", set);
        log.info("运行结果: {}", JSONUtil.toJsonStr(m));
    }
}
