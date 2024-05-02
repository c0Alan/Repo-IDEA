package com.demo.java.basic.type.chars;

import org.junit.Test;

import java.io.UnsupportedEncodingException;

/**
 * char 类型实验类
 * 
 * @author liuxl
 * @date 2018/5/30 12:45
 */
public class CharDemo {

    /**
     * char 所占字节数
     * @throws UnsupportedEncodingException
     */
    @Test
    public void charSize() throws UnsupportedEncodingException {
        System.out.println("a".getBytes("ISO8859-1").length); // 1
        System.out.println("a".getBytes("GB2312").length); // 1
        System.out.println("a".getBytes("GBK").length); // 1
        System.out.println("a".getBytes("UTF-8").length); // 1

        System.out.println("测".getBytes("ISO8859-1").length); // 1
        System.out.println("测".getBytes("GB2312").length); // 2
        System.out.println("测".getBytes("GBK").length); // 2
        System.out.println("测".getBytes("UTF-8").length); // 3
    }

}
