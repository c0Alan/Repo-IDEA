package com.demo.java.interfaces.clone;

/**
 * 接口示例
 *
 * @author liuxilin
 * @date 2022/6/25 18:01
 */
public class CloneTest {

    /**
     * 对象克隆, 深拷贝
     * @param args
     */
    public static void main(String[] args) {
        try {
            Employee original = new Employee("John Q. Public", 50000);
            original.setHireDay(2000, 1, 1);
            Employee copy = original.clone();
            copy.raiseSalary(10);
            copy.setHireDay(2002, 12, 31);
            System.out.println("original=" + original);
            System.out.println("copy=" + copy);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}