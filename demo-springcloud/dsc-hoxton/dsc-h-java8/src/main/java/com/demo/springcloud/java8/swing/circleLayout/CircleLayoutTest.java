package com.demo.springcloud.java8.swing.circleLayout;

import javax.swing.*;
import java.awt.*;

/**
 * 不使用布局管理器
 *
 * @author liuxilin
 * @date 2022/7/6 22:44
 */
public class CircleLayoutTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new CircleLayoutFrame();
            frame.setTitle("CircleLayoutTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}