package com.jd.java8.base.except;

import javax.swing.*;

/**
 * A frame with a panel for testing various exceptions
 */
class ExceptTestFrame extends JFrame
{
   public ExceptTestFrame()
   {
      ExceptTestPanel panel = new ExceptTestPanel();
      add(panel);
      pack();
   }
}