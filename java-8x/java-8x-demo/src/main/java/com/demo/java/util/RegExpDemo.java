package com.demo.java.util;

import org.junit.Test;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式示例
 * @author liuxl
 * @date 2024/6/2
 */
public class RegExpDemo {

    @Test
    public void demo01(){
        String s = "A={1,2,3},B={4,5,6},R=7";
        Matcher m = Pattern.compile("A=\\{(.+)},B=\\{(.+)},R=(.+)").matcher(s);
        if (m.matches()) {
            int[] A = Arrays.stream(m.group(1).split(",")).mapToInt(Integer::parseInt).toArray();
            System.out.println(Arrays.toString(A));
            int[] B = Arrays.stream(m.group(2).split(",")).mapToInt(Integer::parseInt).toArray();
            System.out.println(Arrays.toString(B));
            Integer R = Integer.parseInt(m.group(3));
            System.out.println(R);
        }
    }
}
