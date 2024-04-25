package com.demo.java.java8.base.clazz.abstractdemo;

/**
 * 抽象类示例
 *
 * @author liuxilin
 * @date 2022/6/23 21:56
 */
public class PersonTest
{
   public static void main(String[] args)
   {
      Person[] people = new Person[2];

      // fill the people array with Student and Employee objects
      people[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
      people[1] = new Student("Maria Morris", "computer science");

      // print out names and descriptions of all Person objects
      for (Person p : people) {
         System.out.println(p.getName() + ", " + p.getDescription());
      }
   }
}