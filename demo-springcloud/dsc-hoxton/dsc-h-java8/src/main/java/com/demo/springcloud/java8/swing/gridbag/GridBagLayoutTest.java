package com.demo.springcloud.java8.swing.gridbag;

import javax.swing.*;
import java.awt.*;

/**
 * 网格组布局
 *
 * @author liuxilin
 * @date 2022/7/5 22:53
 */
public class GridBagLayoutTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new FontFrame();
            frame.setTitle("GridBagLayoutTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}