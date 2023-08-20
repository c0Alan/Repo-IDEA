package com.jd.java8.swing.dialog;

import javax.swing.*;
import java.awt.*;

/**
 * 自定义自定义对话框
 *
 * @author liuxilin
 * @date 2022/7/9 13:46
 */
public class DialogTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new DialogFrame();
            frame.setTitle("DialogTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}