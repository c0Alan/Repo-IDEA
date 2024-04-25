package com.demo.java.java8.swing.border;

import javax.swing.*;
import java.awt.*;

/**
 * 边框
 *
 * @author liuxilin
 * @date 2022/7/4 21:56
 */
public class BorderTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BorderFrame();
            frame.setTitle("BorderTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
