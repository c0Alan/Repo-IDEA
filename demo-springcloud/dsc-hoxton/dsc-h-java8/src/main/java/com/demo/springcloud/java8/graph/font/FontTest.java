package com.demo.springcloud.java8.graph.font;

import javax.swing.*;
import java.awt.*;

/**
 * 绘制字符串及其边框
 *
 * @author liuxilin
 * @date 2022/7/3 11:59
 */
public class FontTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new FontFrame();
            frame.setTitle("FontTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}




