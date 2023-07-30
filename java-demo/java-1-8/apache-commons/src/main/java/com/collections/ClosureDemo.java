package com.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.jd.model.Employee;
import com.jd.model.Goods;
import org.apache.commons.collections4.Closure;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.IterableUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.functors.ChainedClosure;
import org.apache.commons.collections4.functors.IfClosure;
import org.apache.commons.collections4.functors.WhileClosure;
import org.junit.Test;

/**
 * 函数式编程 Closure 闭包 封装特定的业务功能
 * 1、Closure
 * 2、IfClosure  IfClosure.ifClosure(断言,功能1,功能2)
 * 3、WhileClosure WhileClosure.whileClosure(断言,功能,标识)
 * 4、ChainedClosure.chainedClosure(功能列表);
 * CollectionUtils.forAllDo(容器,功能类对象);
 *
 * @author liuxilin
 * @date 2018/4/22 10:27
 */
public class ClosureDemo {

    /**
     * 折上减, 先打折商品，进行9折，满百再减20
     */
    @Test
    public void chainClosure() {
        List<Goods> goodsList = new ArrayList<Goods>();
        goodsList.add(new Goods("javase视频", 120, true));
        goodsList.add(new Goods("javaee视频", 100, false));
        goodsList.add(new Goods("高新技术视频", 80, false));

        //满百减20
        Closure<Goods> subtract = new Closure<Goods>() {
            public void execute(Goods goods) {
                if (goods.getPrice() >= 100) {
                    goods.setPrice(goods.getPrice() - 20);
                }
            }
        };

        //打折
        Closure<Goods> discount = new Closure<Goods>() {
            public void execute(Goods goods) {
                if (goods.isDiscount()) {
                    goods.setPrice(goods.getPrice() * 0.9);
                }
            }
        };

        //链式操作
        Closure<Goods> chainClo = ChainedClosure.chainedClosure(discount, subtract);

        //关联
        IterableUtils.forEach(goodsList, chainClo);

        //查看操作后的数据
        for (Goods temp : goodsList) {
            System.out.println(temp);
        }

    }

    /**
     * 确保所有的员工工资都大于10000,如果已经超过的不再上涨
     */
    @Test
    public void whileClosure() {
        //数据
        List<Employee> empList = new ArrayList<Employee>();
        empList.add(new Employee("bjsxt", 20000));
        empList.add(new Employee("is", 10000));
        empList.add(new Employee("good", 5000));

        //业务功能 每次上涨0.2 
        Closure<Employee> cols = new Closure<Employee>() {
            public void execute(Employee emp) {
                emp.setSalary(emp.getSalary() * 1.2);
            }
        };

        //判断
        Predicate<Employee> empPre = new Predicate<Employee>() {
            @Override
            public boolean evaluate(Employee emp) {
                return emp.getSalary() < 10000;
            }
        };
        //false 表示 while结构 先判断后执行   true do..while 先执行后判断
        Closure<Employee> whileCols = WhileClosure.whileClosure(empPre, cols, false);

        //工具类
        IterableUtils.forEach(empList, whileCols);

        //操作后的数据
        Iterator<Employee> empIt = empList.iterator();
        while (empIt.hasNext()) {
            System.out.println(empIt.next());
        }
    }

    /**
     * 二选一  如果是打折商品，进行9折，否则满百减20
     */
    @Test
    public void ifClosure() {
        List<Goods> goodsList = new ArrayList<Goods>();
        goodsList.add(new Goods("javase视频", 120, true));
        goodsList.add(new Goods("javaee视频", 100, false));
        goodsList.add(new Goods("高新技术视频", 80, false));

        //满百减20
        Closure<Goods> subtract = new Closure<Goods>() {
            public void execute(Goods goods) {
                if (goods.getPrice() >= 100) {
                    goods.setPrice(goods.getPrice() - 20);
                }
            }
        };
        //打折
        Closure<Goods> discount = new Closure<Goods>() {
            public void execute(Goods goods) {
                if (goods.isDiscount()) {
                    goods.setPrice(goods.getPrice() * 0.9);
                }
            }
        };

        //判断
        Predicate<Goods> pre = new Predicate<Goods>() {
            public boolean evaluate(Goods goods) {
                return goods.isDiscount();
            }
        };

        //二选一
        Closure<Goods> ifClo = IfClosure.ifClosure(pre, discount, subtract);

        //关联
        IterableUtils.forEach(goodsList, ifClo);

        //查看操作后的数据
        for (Goods temp : goodsList) {
            System.out.println(temp);
        }

    }

    /**
     * 基本操作
     */
    @Test
    public void basic() {
        //数据
        List<Employee> empList = new ArrayList<Employee>();
        empList.add(new Employee("bjsxt", 20000));
        empList.add(new Employee("is", 10000));
        empList.add(new Employee("good", 5000));

        //业务功能
        Closure<Employee> cols = new Closure<Employee>() {
            public void execute(Employee emp) {
                emp.setSalary(emp.getSalary() * 1.2);
            }
        };

        //工具类
        IterableUtils.forEach(empList, cols);

        //操作后的数据
        Iterator<Employee> empIt = empList.iterator();
        while (empIt.hasNext()) {
            System.out.println(empIt.next());
        }
    }

}