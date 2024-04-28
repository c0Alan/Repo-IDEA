package com.demo.java.java8.base.except;

import javax.swing.*;
import java.awt.*;

/**
 * @version 1.34 2015-08-20
 * @author Cay Horstmann
 */
public class ExceptTest
{
   public static void main(String[] args)
   {
      EventQueue.invokeLater(() ->
            {
               JFrame frame = new ExceptTestFrame();
               frame.setTitle("ExceptTest");   
               frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
               frame.setVisible(true);
            });
   }
}




