package com.demo.springcloud.java8.time;

import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * 日期类示例
 *
 * @author liuxilin
 * @date 2022/6/21 22:22
 */
public class DateDemo {
    public static void main(String[] args) {
        demo01();
    }

    /**
     * 打印本月日历
     */
    public static void demo01() {
        LocalDate date = LocalDate.now();
        int month = date.getMonthValue();
        int today = date.getDayOfMonth();

        // Set to start of month
        date = date.minusDays(today - 1);
        DayOfWeek weekday = date.getDayOfWeek();

        // 1 = Monday, ... 7 = Sunday
        int value = weekday.getValue();

        System.out.println("Mon Tue Wed Thu Fri Sat Sun");
        for (int i = 1; i < value; i++) {
            System.out.print("    ");
        }
        while (date.getMonthValue() == month) {
            System.out.printf("%3d", date.getDayOfMonth());
            if (date.getDayOfMonth() == today) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }
            date = date.plusDays(1);
            if (date.getDayOfWeek().getValue() == 1) {
                System.out.println();
            }
        }
        if (date.getDayOfWeek().getValue() != 1) {
            System.out.println();
        }
    }
}