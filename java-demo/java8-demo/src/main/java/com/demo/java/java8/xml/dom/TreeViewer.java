package com.demo.java.java8.xml.dom;

import javax.swing.*;
import java.awt.*;

/**
 * 解析xml并展示为一棵树
 *
 * @author liuxilin
 * @date 2022/8/7 11:20
 */
public class TreeViewer {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new DOMTreeFrame();
            frame.setTitle("TreeViewer");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}






