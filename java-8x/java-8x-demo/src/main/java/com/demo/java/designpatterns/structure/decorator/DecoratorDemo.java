package com.demo.java.designpatterns.structure.decorator;

import org.junit.Test;

/**
 * Decorator 装饰器模式, 给一个对象动态增加一些新的功能
 * 常用于功能增强，如 HttpServletRequestWrapper、HttpServletResponseWrapper 实现敏感词处理，HTML标签处理等
 *
 * @author liuxl
 * @date 2024/4/29
 */
public class DecoratorDemo {
  
    public static void main(String[] args) {  

    }

    /**
     * 在source.method()方法上面扩展代码
     */
    @Test
    public void test01() {
        Sourceable source = new Source();
        Sourceable obj = new Decorator(source);
        obj.method();
    }
} 