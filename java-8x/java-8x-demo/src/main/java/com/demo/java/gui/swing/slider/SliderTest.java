package com.demo.java.gui.swing.slider;

import javax.swing.*;
import java.awt.*;

/**
 * 滑动条
 *
 * @author liuxilin
 * @date 2022/7/4 22:10
 */
public class SliderTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            SliderFrame frame = new SliderFrame();
            frame.setTitle("SliderTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}