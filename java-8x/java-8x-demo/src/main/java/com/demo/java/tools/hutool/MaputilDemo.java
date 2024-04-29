package com.demo.java.tools.hutool;

import cn.hutool.core.map.MapUtil;
import lombok.extern.slf4j.Slf4j;

import java.util.HashMap;
import java.util.Map;

/**
 * Maputil Demo
 * @author liuxilin
 * @date 2022年05月19日 10:26
 */
@Slf4j
public class MaputilDemo {
    public static void main(String[] args) {
        demo01();
    }

    /**
     * map key 转小驼峰
     */
    public static void demo01(){
        Map m = new HashMap<>();
        m.put("AAA", "aaa");
        m.put("BBB", "bbb");
        m.put("CCC_DD", "ccc");

        Map m2 = MapUtil.toCamelCaseMap(m);
        log.info("demo运行结果: {}", m2);
    }
}
