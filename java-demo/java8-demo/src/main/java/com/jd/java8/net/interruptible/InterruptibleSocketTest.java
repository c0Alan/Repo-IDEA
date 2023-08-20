package com.jd.java8.net.interruptible;

import javax.swing.*;
import java.awt.*;

/**
 * 中断套接字
 *
 * @author liuxilin
 * @date 2022/8/11 22:25
 */
public class InterruptibleSocketTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFrame frame = new InterruptibleSocketFrame();
            frame.setTitle("InterruptibleSocketTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}


