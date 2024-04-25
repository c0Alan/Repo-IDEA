package com.demo.java.java8.base.localInnerClass;

import javax.swing.*;

/**
 * This program demonstrates the use of local inner classes.
 * @version 1.01 2015-05-12
 * @author Cay Horstmann
 */
public class LocalInnerClassTest
{
   public static void main(String[] args)
   {
      TalkingClock clock = new TalkingClock();
      clock.start(1000, true);

      // keep program running until user selects "Ok"
      JOptionPane.showMessageDialog(null, "Quit program?");
      System.exit(0);
   }
}


