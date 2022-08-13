package com.demo.springcloud.java8.swing.text;

import javax.swing.*;
import java.awt.*;

/**
 * 文本组件, 标签, 文本域(输入框), 密码域(密码输入框), 文本区(带滚动条)
 *
 * @author liuxilin
 * @date 2022/7/4 12:46
 */
public class TextComponentTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new TextComponentFrame();
            frame.setTitle("TextComponentTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
