package com.demo.springcloud.java8.base.clazz.abstractdemo;


public class Student extends Person
{
   private String major;

   public Student(String name, String major)
   {
      // pass n to superclass constructor
      super(name);
      this.major = major;
   }

   @Override
   public String getDescription()
   {
      return "a student majoring in " + major;
   }
}
