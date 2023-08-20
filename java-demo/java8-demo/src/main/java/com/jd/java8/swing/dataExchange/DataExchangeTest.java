package com.jd.java8.swing.dataExchange;

import javax.swing.*;
import java.awt.*;

/**
 * 对话框数据交换
 *
 * @author liuxilin
 * @date 2022/7/9 16:41
 */
public class DataExchangeTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new DataExchangeFrame();
            frame.setTitle("DataExchangeTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
