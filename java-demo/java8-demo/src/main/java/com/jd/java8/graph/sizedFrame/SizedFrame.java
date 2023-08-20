package com.jd.java8.graph.sizedFrame;

import javax.swing.*;
import java.awt.*;

class SizedFrame extends JFrame {
    public SizedFrame() {
        // get screen dimensions

        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenHeight = screenSize.height;
        int screenWidth = screenSize.width;

        // set frame width, height and let platform pick screen location

        setSize(screenWidth / 2, screenHeight / 2);
        setLocationByPlatform(true);

        // set frame icon
        System.out.println(this.getClass().getResource("").getPath());
        System.out.println(Thread.currentThread().getContextClassLoader().getResource(""));
        String iconPath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        iconPath += "static/icon.gif";
        System.out.println(iconPath);
        Image img = new ImageIcon(iconPath).getImage();
        setIconImage(img);
    }
}