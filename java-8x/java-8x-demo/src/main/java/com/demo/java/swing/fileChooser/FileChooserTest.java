package com.demo.java.swing.fileChooser;

import javax.swing.*;
import java.awt.*;

/**
 * 文件对话框
 *
 * @author liuxilin
 * @date 2022/7/9 18:38
 */
public class FileChooserTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new ImageViewerFrame();
            frame.setTitle("FileChooserTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
