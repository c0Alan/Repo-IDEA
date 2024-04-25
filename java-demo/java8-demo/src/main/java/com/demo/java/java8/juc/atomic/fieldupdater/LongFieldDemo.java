package com.demo.java.java8.juc.atomic.fieldupdater;

import java.util.concurrent.atomic.AtomicLongFieldUpdater;

/**
 * AtomicLongFieldUpdater示例
 * AtomicLongFieldUpdater可以对指定"类的 'volatile long'类型的成员"进行原子更新。
 * 它是基于反射原理实现的。
 *
 * @author liuxilin
 * @date 2018/5/20 21:35
 */
public class LongFieldDemo {

    public static void main(String[] args) {

        // 获取Person的class对象
        Class cls = Person.class;
        // 新建AtomicLongFieldUpdater对象，传递参数是“class对象”和“long类型在类中对应的名称”
        AtomicLongFieldUpdater mAtoLong = AtomicLongFieldUpdater.newUpdater(cls, "id");
        Person person = new Person(12345678L);

        // 比较person的"id"属性，如果id的值为12345678L，则设置为1000。
        mAtoLong.compareAndSet(person, 12345678L, 1000);
        System.out.println("id=" + person.getId());
    }
}

