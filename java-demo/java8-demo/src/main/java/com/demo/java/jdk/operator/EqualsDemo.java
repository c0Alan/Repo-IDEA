package com.demo.java.jdk.operator;

import org.junit.Test;

/**
 * @author liuxl
 * @date 2018/6/1 12:24
 */
public class EqualsDemo {

    /**
     * ==操作符专门用来比较两个变量的值是否相等, 也就是用于比较变量所对应的内存中所存
     * 储的数值是否相同, 要比较两个基本类型的数据或两个引用变量是否相等, 只能用==操作符。
     * 如果一个变量指向的数据是对象类型的, 那么, 这时候涉及了两块内存, 对象本身占用一块
     * 内存(堆内存), 变量也占用一块内存, 例如Objet obj = new Object();变量obj 是一个内存,
     * new Object()是另一个内存, 此时, 变量obj 所对应的内存中存储的数值就是对象占用的那
     * 块内存的首地址。
     */
    @Test
    public void testEquals() {
        String a = new String("foo");
        String b = new String("foo");
        System.out.println(a == b); // false
        System.out.println(a.equals(b)); // true
    }
}
