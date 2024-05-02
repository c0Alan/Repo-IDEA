package com.demo.java.clazz.reflection;

import java.util.ArrayList;

/**
 * 反射示例
 *
 * @author liuxilin
 * @date 2022/6/25 15:57
 */
public class ObjectAnalyzerTest
{

   /**
    * 利用反射将类信息转换为字符串打印
    * @param args
    */
   public static void main(String[] args)
   {
      ArrayList<Integer> squares = new ArrayList<>();
      for (int i = 1; i <= 5; i++) {
         squares.add(i * i);
      }
      System.out.println(new ObjectAnalyzer().toString(squares));
   }
}