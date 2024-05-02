package com.demo.java.clazz;

import com.demo.java.entity.*;
import org.junit.Test;

/**
 *
 *
 * @author liuxilin
 * @date 2022/6/23 22:27
 */
public class ClassDemo {
    public static void main(String[] args) {

    }


    /**
     * 抽象类
     */
    @Test
    public void test03() {
        Person[] people = new Person[2];

        // fill the people array with Student and Employee objects
        people[0] = new Employee("Harry Hacker", 50000, 1989, 10, 1);
        people[1] = new Student("Maria Morris", "computer science");

        // print out names and descriptions of all Person objects
        for (Person p : people) {
            System.out.println(p.getName() + ", " + p.getDescription());
        }
    }

    /**
     * 继承
     */
    @Test
    public void test02() {
        // construct a Manager object
        Manager02 boss = new Manager02("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);

        Employee03[] staff = new Employee03[3];

        // fill the staff array with Manager and Employee objects

        staff[0] = boss;
        staff[1] = new Employee03("Harry Hacker", 50000, 1989, 10, 1);
        staff[2] = new Employee03("Tommy Tester", 40000, 1990, 3, 15);

        // print out information about all Employee objects
        for (Employee03 e : staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
        }
    }

    /**
     * equals 方法示例
     */
    @Test
    public void test01() {
        com.demo.java.entity.Employee02 alice1 = new com.demo.java.entity.Employee02("Alice Adams", 75000, 1987, 12, 15);
        com.demo.java.entity.Employee02 alice2 = alice1;
        com.demo.java.entity.Employee02 alice3 = new com.demo.java.entity.Employee02("Alice Adams", 75000, 1987, 12, 15);
        com.demo.java.entity.Employee02 bob = new com.demo.java.entity.Employee02("Bob Brandson", 50000, 1989, 10, 1);

        System.out.println("alice1 == alice2: " + (alice1 == alice2));

        System.out.println("alice1 == alice3: " + (alice1 == alice3));

        System.out.println("alice1.equals(alice3): " + alice1.equals(alice3));

        System.out.println("alice1.equals(bob): " + alice1.equals(bob));

        System.out.println("bob.toString(): " + bob);

        Manager carl = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        Manager boss = new Manager("Carl Cracker", 80000, 1987, 12, 15);
        boss.setBonus(5000);
        System.out.println("boss.toString(): " + boss);
        System.out.println("carl.equals(boss): " + carl.equals(boss));
        System.out.println("alice1.hashCode(): " + alice1.hashCode());
        System.out.println("alice3.hashCode(): " + alice3.hashCode());
        System.out.println("bob.hashCode(): " + bob.hashCode());
        System.out.println("carl.hashCode(): " + carl.hashCode());
    }
}