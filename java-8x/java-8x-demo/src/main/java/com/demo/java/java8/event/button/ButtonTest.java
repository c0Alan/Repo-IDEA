package com.demo.java.java8.event.button;

import javax.swing.*;
import java.awt.*;

/**
 * 点击按钮修改面板背景色
 *
 * @author liuxilin
 * @date 2022/7/3 16:28
 */
public class ButtonTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ButtonFrame();
            frame.setTitle("ButtonTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}