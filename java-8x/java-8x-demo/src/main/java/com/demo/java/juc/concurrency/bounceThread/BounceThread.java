package com.demo.java.juc.concurrency.bounceThread;

import javax.swing.*;
import java.awt.*;

/**
 * Shows animated bouncing balls.
 *
 * @author Cay Horstmann
 * @version 1.34 2015-06-21
 */
public class BounceThread {
    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            JFrame frame = new BounceFrame();
            frame.setTitle("BounceThread");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}


