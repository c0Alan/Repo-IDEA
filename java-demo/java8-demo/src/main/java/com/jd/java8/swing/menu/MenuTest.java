package com.jd.java8.swing.menu;

import javax.swing.*;
import java.awt.*;

/**
 * 菜单
 *
 * @author liuxilin
 * @date 2022/7/5 22:04
 */
public class MenuTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new MenuFrame();
            frame.setTitle("MenuTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}