package com.jd.java8.swing.groupLayout;

import javax.swing.*;
import java.awt.*;

/**
 * 组布局
 *
 * @author liuxilin
 * @date 2022/7/6 22:27
 */
public class GroupLayoutTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new FontFrame();
            frame.setTitle("GroupLayoutTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}