package com.demo.java.innerClass;


import javax.swing.*;

/**
 * 内部类示例
 *
 * @author liuxilin
 * @date 2022/6/25 21:53
 */
public class InnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock(1000, true);
        clock.start();

        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}


