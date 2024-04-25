package com.demo.java.java8.swing.toolBar;

import javax.swing.*;
import java.awt.*;

/**
 * 工具栏
 *
 * @author liuxilin
 * @date 2022/7/5 22:26
 */
public class ToolBarTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            ToolBarFrame frame = new ToolBarFrame();
            frame.setTitle("ToolBarTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}