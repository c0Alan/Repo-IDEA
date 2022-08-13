package com.demo.springcloud.java8.event.plaf;

import javax.swing.*;
import java.awt.*;

/**
 * 通过按钮改变面板UI显示风格
 *
 * @author liuxilin
 * @date 2022/7/3 17:08
 */
public class PlafTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new PlafFrame();
            frame.setTitle("PlafTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}