package com.demo.java.java8.graph.image;

import javax.swing.*;
import java.awt.*;

/**
 * 平铺图像的窗口
 *
 * @author liuxilin
 * @date 2022/7/3 12:00
 */
public class ImageTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new ImageFrame();
            frame.setTitle("ImageTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}




