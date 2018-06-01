package com.jdk.type.integer;

import org.apache.log4j.Logger;
import org.junit.Test;

/**
 * 整型类型测试
 *
 * @author liuxl
 * @date 2018/5/2 15:55
 */
public class IntegerDemo {
    private static final Logger logger = Logger.getLogger(IntegerDemo.class);

    /**
     * 跟int比较相等
     */
    @Test
    public void equalsInt() {
        Integer num1 = -1;
        int num2 = -1;
        int num3 = 2;
        System.out.println(num1 == num2); // true
        System.out.println(num1 == num3); // false
    }

    /**
     * 测试负数类型的Integer
     */
    public static void negativeInteger() {
        Integer num1 = -1;
        int num2 = -1;
        System.out.println(Integer.valueOf(num2).equals(num1));
    }

    /**
     * 带空格字符串转换
     */
    @Test
    public void blankString() {
//        Integer i = Integer.valueOf("123   "); // 这里加空格报错
        Integer i = Integer.valueOf("123"); // 这里加空格报错

        System.out.println(i);
    }

    /**
     * 测试拆箱
     */
    @Test
    public void equals() {
        Integer i = null;
        System.out.println(i == 1); // 这里拆箱时报空指针错误
    }

    @Test
    public void incr() {
        Integer i = 0;
        logger.info(i.hashCode());

        incr(i);
        logger.info(i); // 0

        incr(i);
        logger.info(i); // 0

        incr(i);
        logger.info(i); // 0
    }

    public void incr(Integer n) {
        logger.info("before: " + n.hashCode());
        n = n + 1;
        logger.info("after: " + n.hashCode());
    }

    /**
     * ①无论如何，Integer与new Integer不会相等。不会经历拆箱过程，i7的引用指向堆，
     * 而new Integer()指向专门存放他的内存（常量池），他们的内存地址不一样，所以为false（如L24）。
     * <p>
     * ②两个都是非new出来的Integer，如果数在-128到127之间，则是true(如L18),否则为false(如L18)。
     * java在编译Integer i2 = 128的时候,被翻译成-> Integer i2 = Integer.valueOf(128);
     * 而valueOf()函数会对-128到127之间的数进行缓存。
     * <p>
     * ③两个都是new出来的,都为false（如L27）。
     * <p>
     * ④int和integer(无论new否)比，都为true，因为会把Integer自动拆箱为int再去比（如L13、L14）。
     */
    @Test
    public void equalsLimit() {
        int i = 128;
        Integer i2 = 128; // Integer会自动装箱
        Integer i3 = new Integer(128);

        System.out.println(i == i2); // Integer会自动拆箱为int，所以为true
        System.out.println(i == i3); // Integer会自动拆箱为int，所以为true
        System.out.println("**************");
        Integer i5 = 127; // java在编译的时候,被翻译成-> Integer i5 = Integer.valueOf(127);
        Integer i6 = 127;
        System.out.println(i5 == i6); // Integer会自动拆箱为int再比较, true
        Integer _i5 = 128;
        Integer _i6 = 128;
        System.out.println(_i5 == _i6); //false
        Integer ii5 = new Integer(127);
        System.out.println(i5 == ii5); // false
        Integer i7 = new Integer(128);
        Integer i8 = new Integer(128);
        System.out.println(i7 == i8); // false
    }
}

