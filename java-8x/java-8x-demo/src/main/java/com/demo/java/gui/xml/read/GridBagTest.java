package com.demo.java.gui.xml.read;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * This program shows how to use an XML file to describe a gridbag layout
 *
 * @author Cay Horstmann
 * @version 1.12 2016-04-27
 */
public class GridBagTest {
    public static void main(String[] args) {
        EventQueue.invokeLater(() ->
        {
            JFileChooser chooser = new JFileChooser(".");
            chooser.showOpenDialog(null);
            // fontdialog.xml / fontdialog-schema.xml
            File file = chooser.getSelectedFile();
            JFrame frame = new FontFrame(file);
            frame.setTitle("GridBagTest");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}


