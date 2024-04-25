package com.demo.java.jdk.clazz.enumtype;

/**
 * 用法六：使用接口组织枚举
 *
 * @author liuxl
 * @date 2018/4/7 9:29
 */
public interface Food {
    enum Coffee implements Food {
        BLACK_COFFEE, DECAF_COFFEE, LATTE, CAPPUCCINO
    }

    enum Dessert implements Food {
        FRUIT, CAKE, GELATO
    }
}  