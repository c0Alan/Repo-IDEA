package com.demo.java.entity;

/**
 * 抽象类，有一个方法为抽象方法的类为抽象类，不能实例化，只能被继承。
 *
 * @author liuxl
 * @date 2024/5/2
 */
public abstract class AbstractPerson {
    public abstract String getDescription();

    private String name;

    public AbstractPerson(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
