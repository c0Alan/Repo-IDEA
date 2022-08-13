package com.demo.springcloud.java8.swing.checkBox;

import javax.swing.*;
import java.awt.*;

/**
 * 复选框
 *
 * @author liuxilin
 * @date 2022/7/4 21:56
 */
public class CheckBoxTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new CheckBoxFrame();
            frame.setTitle("CheckBoxTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
