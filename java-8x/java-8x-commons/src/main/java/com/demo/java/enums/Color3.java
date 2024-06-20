package com.demo.java.enums;

/**
 * 用法四：覆盖枚举的方法
 *
 * @author liuxl
 * @date 2018/4/7 9:27
 */
public enum Color3 {
    RED("红色", 1), GREEN("绿色", 2), BLANK("白色", 3), YELLO("黄色", 4);
    // 成员变量  
    private String name;
    private int index;

    // 构造方法  
    private Color3(String name, int index) {
        this.name = name;
        this.index = index;
    }

    //覆盖方法  
    @Override
    public String toString() {
        return this.index + "_" + this.name;
    }
} 