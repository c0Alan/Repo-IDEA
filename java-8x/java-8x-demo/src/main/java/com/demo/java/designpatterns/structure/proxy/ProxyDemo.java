package com.demo.java.designpatterns.structure.proxy;

import org.junit.Test;

/**
 * Proxy 代理模式，多一个代理类出来，替原对象进行一些操作
 * 跟装饰模式的区别：装饰模式是动态的，代理模式是静态的
 *
 * @author liuxl
 * @date 2024/4/29
 */
public class ProxyDemo {
  
    public static void main(String[] args) {  

    }

    @Test
    public void test01() {
        Sourceable source = new Proxy();
        source.method();
    }
  
}