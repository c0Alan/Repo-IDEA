package com.demo.java.clazz;

import com.demo.java.entity.Employee07;
import com.demo.java.entity.Employee06;
import com.demo.java.entity.Interface01;
import com.demo.java.entity.InterfaceChild01;
import org.junit.Test;

import java.util.Arrays;

/**
 * 接口定义/实现示例
 *
 * @author liuxilin
 * @date 2022/6/25 16:44
 */
public class InterfaceDemo {

    @Test
    public void test03() {
        Interface01 i = new InterfaceChild01();
        i.method01();
        i.method02();
    }


    /**
     * 对象克隆, 深拷贝
     */
    @Test
    public void test02() {
        try {
            Employee07 original = new Employee07("John Q. Public", 50000);
            original.setHireDay(2000, 1, 1);
            Employee07 copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2002, 12, 31);
            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    /**
     * 实现 Employee 对象按 salary 属性排序
     */
    @Test
    public void test01() {
        Employee06[] staff = new Employee06[3];

        staff[0] = new Employee06("Harry Hacker", 35000);
        staff[1] = new Employee06("Carl Cracker", 75000);
        staff[2] = new Employee06("Tony Tester", 38000);

        Arrays.sort(staff);

        // print out information about all Employee objects
        for (Employee06 e : staff) {
            System.out.println("name=" + e.getName() + ",salary=" + e.getSalary());
        }
    }
}