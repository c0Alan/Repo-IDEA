package com.jd.java8.swing.optionDialog;

import javax.swing.*;
import java.awt.*;

/**
 * 选项对话框
 *
 * @author liuxilin
 * @date 2022/7/9 9:18
 */
public class OptionDialogTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new OptionDialogFrame();
            frame.setTitle("OptionDialogTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
