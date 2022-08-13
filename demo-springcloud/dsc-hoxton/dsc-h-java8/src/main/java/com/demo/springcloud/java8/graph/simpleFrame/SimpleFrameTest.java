package com.demo.springcloud.java8.graph.simpleFrame;

import javax.swing.*;
import java.awt.*;


public class SimpleFrameTest {

    /**
     * 所有的Swing 组件必须由事件分派线程（event dispatch thread ) 进行配置，
     * 线程将鼠标点击和按键控制转移到用户接口组件。
     * @param args
     */
    public static void main(String[] args) {
        // 事件分派线程
        EventQueue.invokeLater(() ->
        {
            SimpleFrame frame = new SimpleFrame();
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}


