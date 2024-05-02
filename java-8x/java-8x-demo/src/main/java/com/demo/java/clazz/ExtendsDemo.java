package com.demo.java.clazz;

import com.demo.java.entity.ChildDemo01;
import com.demo.java.entity.ChildDemo02;
import com.demo.java.entity.IParentDemo01;
import org.junit.Test;

/**
 * 继承
 * @author liuxl
 * @date 2024/5/2
 */
public class ExtendsDemo {

    @Test
    public void test02(){
        ChildDemo02 demo02 = new ChildDemo02();
        ChildDemo01 demo01 = new ChildDemo01();

        demo01.printList();
        demo02.printList();
    }

    @Test
    public void test01(){
        IParentDemo01 demo01 = new ChildDemo01();
        System.out.println(demo01.getName()); // child
    }
}
