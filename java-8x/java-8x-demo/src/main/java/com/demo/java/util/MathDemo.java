package com.demo.java.util;

import org.junit.Test;

public class MathDemo {

    @Test
    public void calculate(){
        // ceil 的英文意义是天花板, 该方法就表示向上取整,
        System.out.println(Math.ceil(11.3)); // 12.0
        System.out.println(Math.ceil(-11.3)); // -11.0

        // floor 的英文意义是地板, 该方法就表示向下取整,
        System.out.println(Math.floor(11.6)); // 11.0
        System.out.println(Math.floor(-11.6)); // -12.0

        // round 方法, 它表示"四舍五入", 算法为Math.floor(x+0.5), 即将原来的数字加上0.5后再向下取整, 所以,
        System.out.println(Math.round(11.5)); // 12
        System.out.println(Math.round(-11.5)); // -11
    }
}
