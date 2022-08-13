package com.demo.springcloud.java8.swing.comboBox;

import javax.swing.*;
import java.awt.*;

/**
 * 组合框
 *
 * @author liuxilin
 * @date 2022/7/4 22:03
 */
public class ComboBoxTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ComboBoxFrame();
            frame.setTitle("ComboBoxTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}