package com.demo.java.flow.switches;

import org.junit.Test;

/**
 * witch 试验类
 *
 * @author liuxl
 * @date 2018/5/30 12:22
 */
public class SwitchDemo {

    @Test
    public void types() {
        byte b = 1;
        short s = 1;
        char c = '1';
        long l = 1;
        String str = "1";

        switch (b) { // good
            case 1:
                System.out.println("good");
                break;
            default:
                System.out.println("bad");
        }

        switch (s) { // good
            case 1:
                System.out.println("good");
                break;
            default:
                System.out.println("bad");
        }

        System.out.println((int)c); // 49
        switch (c) { // bad 此处会进行类型转换, char 转换为 int
            case 1:
                System.out.println("good");
                break;
            default:
                System.out.println("bad");
        }

        switch (c) { // good
            case '1':
                System.out.println("good");
                break;
            default:
                System.out.println("bad");
        }

/*        switch (l) { // 此处报错, long 类型不支持 switch, 因为long 无法向下转换为 Int 型
            case 1:
                System.out.println("good");
                break;
            default:
                System.out.println("bad");
        }*/

        switch (str) { // good
            case "1":
                System.out.println("good");
                break;
            default:
                System.out.println("bad");
        }

    }
}
