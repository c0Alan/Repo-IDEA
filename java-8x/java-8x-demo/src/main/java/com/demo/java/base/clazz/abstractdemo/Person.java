package com.demo.java.base.clazz.abstractdemo;

public abstract class Person
{
   public abstract String getDescription();

   private String name;

   public Person(String name)
   {
      this.name = name;
   }

   public String getName()
   {
      return name;
   }
}
