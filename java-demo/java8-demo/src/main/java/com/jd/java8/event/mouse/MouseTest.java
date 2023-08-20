package com.jd.java8.event.mouse;

import javax.swing.*;
import java.awt.*;

/**
 * 鼠标点击/双击/拖拽动作
 *
 * @author liuxilin
 * @date 2022/7/3 17:49
 */
public class MouseTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new MouseFrame();
            frame.setTitle("MouseTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}