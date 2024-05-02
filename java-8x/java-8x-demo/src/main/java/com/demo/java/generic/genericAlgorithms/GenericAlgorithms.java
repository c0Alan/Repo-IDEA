package com.demo.java.generic.genericAlgorithms;

import java.util.*;

/**
 * @version 1.00 2015-05-21
 * @author Cay Horstmann
 */
public class GenericAlgorithms
{
   public static void main(String[] args)
   {
      Pair<String> p = Pair.makePair(String::new);
      System.out.println(p);
      
      p = Pair.makePair(String.class);
      System.out.println(p);      
      
      String[] ss = ArrayAlg.minmax("Tom", "Dick", "Harry");
      System.out.println(Arrays.toString(ss));
      
      // ss = ArrayAlg.minmax(String[]::new, "Tom", "Dick", "Harry");
      ss = ArrayAlg.minmax("Tom", "Dick", "Harry");
      System.out.println(Arrays.toString(ss));
   }
}



