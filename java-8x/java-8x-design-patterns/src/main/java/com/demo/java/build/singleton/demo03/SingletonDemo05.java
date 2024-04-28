package com.demo.java.build.singleton.demo03;

import org.junit.Test;

/**
 * 5. 枚举方法
 * Effective Java作者Josh Bloch 提倡的方式，在我看来简直是来自神的写法。解决了以下三个问题：
 * (1)自由序列化。
 * (2)保证只有一个实例。
 * (3)线程安全。
 * 这种充满美感的代码真的已经终结了其他一切实现方法了。(原作者这么说的)
 *
 * @author liuxilin
 * @date 2018/5/19 15:33
 */
enum SingletonDemo05 {
    INSTANCE;

    public void otherMethods() {
        System.out.println("Something");
    }

}