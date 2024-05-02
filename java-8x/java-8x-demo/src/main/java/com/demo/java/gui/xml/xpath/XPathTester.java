package com.demo.java.gui.xml.xpath;

import javax.swing.*;
import java.awt.*;

/**
 * 通过 xpath 获取xml文件内容
 * gridbag/row[1]/cell[1]/@anchor
 *
 * @author liuxilin
 * @date 2022/8/7 20:33
 */
public class XPathTester {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new XPathFrame();
            frame.setTitle("XPathTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}


