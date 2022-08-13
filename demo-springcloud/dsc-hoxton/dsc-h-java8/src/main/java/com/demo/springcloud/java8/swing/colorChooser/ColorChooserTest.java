package com.demo.springcloud.java8.swing.colorChooser;

import javax.swing.*;
import java.awt.*;

/**
 * 颜色选择器
 *
 * @author liuxilin
 * @date 2022/7/9 21:34
 */
public class ColorChooserTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ColorChooserFrame();
            frame.setTitle("ColorChooserTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
