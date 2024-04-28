package com.demo.java.java8.graph.sizedFrame;

import javax.swing.*;
import java.awt.*;

/**
 * 按钮跟键盘事件动作
 *
 * @author liuxilin
 * @date 2022/7/3 17:30
 */
public class SizedFrameTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new SizedFrame();
            frame.setTitle("SizedFrame");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}


