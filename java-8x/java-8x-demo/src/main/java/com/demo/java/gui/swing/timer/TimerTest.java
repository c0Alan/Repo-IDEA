package com.demo.java.gui.swing.timer;


import javax.swing.*;
import java.awt.event.ActionListener;
// to resolve conflict with java.util.Timer

public class TimerTest {

    /**
     * 每10秒执行一次后台任务
     * @param args
     */
    public static void main(String[] args) {
        ActionListener listener = new TimePrinter();

        // construct a timer that calls the listener
        // once every 10 seconds
        Timer t = new Timer(10000, listener);
        t.start();

        JOptionPane.showMessageDialog(null, "Quit program?");
        System.exit(0);
    }
}


