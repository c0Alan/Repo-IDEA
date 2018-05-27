package com.jdk.clazz.enumtype;

import org.junit.Test;

/**
 * 用法三：向枚举中添加新方法
 *
 * @author liuxl
 * @date 2018/4/7 9:24
 */
public enum Color2 {
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
    // 成员变量  
    private String name;
    private int index;

    // 构造方法  
    private Color2(String name, int index) {
        this.name = name;
        this.index = index;
    }

    // 普通方法  
    public static String getName(int index) {
        for (Color2 c : Color2.values()) {
            if (c.getIndex() == index) {
                return c.name;
            }
        }
        return null;
    }

    // get set 方法  
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    /**
     * 报错
     * java.string.Exception: Test class should have exactly one public constructor
     */
    @Test
    public void test(){
        System.out.println("test");
    }
}