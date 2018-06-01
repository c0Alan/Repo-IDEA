package com.juc.exercise.demo01;

public class Subject {
    // 这里不加 volatile 会出现死循环, 线程栈永远不读主内存
    private volatile String value;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
