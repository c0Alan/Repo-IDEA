package com.demo.java.lambda;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.util.Arrays;
import java.util.Date;

/**
 * lambda 示例
 *
 * @author liuxilin
 * @date 2022/6/25 20:17
 */
@Slf4j
public class LambdaTest {

    /**
     * 排序
     *
     * @param args
     */
    public static void main(String[] args) {
        String[] planets = new String[]{"Mercury", "Venus", "Earth", "Mars",
                "Jupiter", "Saturn", "Uranus", "Neptune"};
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted in dictionary order:");
        Arrays.sort(planets);
        System.out.println(Arrays.toString(planets));
        System.out.println("Sorted by length:");
        Arrays.sort(planets, (first, second) -> first.length() - second.length());
        System.out.println(Arrays.toString(planets));

        Timer t = new Timer(1000, event ->
                System.out.println("The time is " + new Date()));
        t.start();

        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }


}
