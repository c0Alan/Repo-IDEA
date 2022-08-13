package com.demo.springcloud.java8.base.innerClass.anonymousInnerClass;

import javax.swing.*;

/**
 * 匿名内部类示例
 *
 * @author liuxilin
 * @date 2022/6/25 22:22
 */
public class AnonymousInnerClassTest {
    public static void main(String[] args) {
        TalkingClock clock = new TalkingClock();
        clock.start(1000, true);

        // keep program running until user selects "Ok"
        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}


