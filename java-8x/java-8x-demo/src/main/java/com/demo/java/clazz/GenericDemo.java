package com.demo.java.clazz;

import com.demo.java.entity.ArrayAlg01;
import com.demo.java.entity.Pair01;
import com.demo.java.entity.ArrayAlg02;
import com.demo.java.entity.Pair02;
import com.demo.java.entity.Employee05;
import com.demo.java.entity.Manager03;
import com.demo.java.entity.Pair03;
import com.demo.java.entity.PairAlg03;
import com.demo.java.entity.ArrayAlg;
import com.demo.java.entity.Pair;
import org.junit.Test;

import java.time.LocalDate;
import java.util.*;

/**
 * 泛型示例
 *
 * @author Cay Horstmann
 * @version 1.00 2015-05-21
 */
public class GenericDemo {

    /**
     *
     */
    @Test
    public void test04()  {
        Manager03 ceo = new Manager03("Gus Greedy", 800000, 2003, 12, 15);
        Manager03 cfo = new Manager03("Sid Sneaky", 600000, 2003, 12, 15);
        Pair03<Manager03> buddies = new Pair03<>(ceo, cfo);
        printBuddies(buddies);

        ceo.setBonus(1000000);
        cfo.setBonus(500000);
        Manager03[] managers = {ceo, cfo};

        Pair03<Employee05> result = new Pair03<>();
        minmaxBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName()
                + ", second: " + result.getSecond().getName());
        maxminBonus(managers, result);
        System.out.println("first: " + result.getFirst().getName()
                + ", second: " + result.getSecond().getName());
    }

    public static void printBuddies(Pair03<? extends Employee05> p) {
        Employee05 first = p.getFirst();
        Employee05 second = p.getSecond();
        System.out.println(first.getName() + " and " + second.getName() + " are buddies.");
    }

    public static void minmaxBonus(Manager03[] a, Pair03<? super Manager03> result) {
        if (a.length == 0) {
            return;
        }
        Manager03 min = a[0];
        Manager03 max = a[0];
        for (int i = 1; i < a.length; i++) {
            if (min.getBonus() > a[i].getBonus()) {
                min = a[i];
            }
            if (max.getBonus() < a[i].getBonus()) {
                max = a[i];
            }
        }
        result.setFirst(min);
        result.setSecond(max);
    }

    public static void maxminBonus(Manager03[] a, Pair03<? super Manager03> result) {
        minmaxBonus(a, result);
        // OK--swapHelper captures wildcard type
        PairAlg03.swapHelper(result);
    }
    // Can't write public static <T super manager> ...

    /**
     *
     */
    @Test
    public void test03() {
        LocalDate[] birthdays =
                {
                        LocalDate.of(1906, 12, 9), // G. Hopper
                        LocalDate.of(1815, 12, 10), // A. Lovelace
                        LocalDate.of(1903, 12, 3), // J. von Neumann
                        LocalDate.of(1910, 6, 22), // K. Zuse
                };
        Pair02<LocalDate> mm = ArrayAlg02.minmax(birthdays);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }


    /**
     * 打印最大最小值
     */
    @Test
    public void test02() {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair01<String> mm = ArrayAlg01.minmax(words);
        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }

    /**
     * 泛型示例
     */
    @Test
    public void test01() {
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



