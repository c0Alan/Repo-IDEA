package com.demo.java.gui.swing.radioButton;

import javax.swing.*;
import java.awt.*;

/**
 * 单选框
 *
 * @author liuxilin
 * @date 2022/7/4 21:56
 */
public class RadioButtonTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new RadioButtonFrame();
            frame.setTitle("RadioButtonTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}