package com.demo.java.java8.graph.draw;

import javax.swing.*;
import java.awt.*;

/**
 * 绘制了一个矩形；
 * 矩形的内接椭圆；
 * 矩形的对角线以及以矩形中心为圆点的圆
 *
 * @author liuxilin
 * @date 2022/7/3 11:04
 */
public class DrawTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new DrawFrame();
            frame.setTitle("DrawTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}




