package com.demo.java.designpatterns.structure.bridge;

import org.junit.Test;

/**
 * Bridge 桥接模式，桥接模式是指：将抽象化与实现化解耦，使得二者可以独立变化。它是一种对象结构型模式，它通过引入中间层，将抽象化与实现化解耦，使得二者可以独立变化。
 * 常用的有JDBC桥DriverManager
 *
 * @author liuxl
 * @date 2024/4/29
 */
public class BridgeDemo {
      
    public static void main(String[] args) {  
          

    }

    @Test
    public void test01() {
        Bridge bridge = new MyBridge();

        /*调用第一个对象*/
        Sourceable source1 = new SourceSub1();
        bridge.setSource(source1);
        bridge.method();

        /*调用第二个对象*/
        Sourceable source2 = new SourceSub2();
        bridge.setSource(source2);
        bridge.method();
    }
}  