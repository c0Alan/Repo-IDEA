package com.collections;

import com.model.Employee;
import com.model.Level;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.SwitchTransformer;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class TransformedTest {
    /**
     * 自定义类型转换
     * 1、new Transformer() +transform
     * 2、SwitchTransformer
     * CollectionUtils.collect(容器,转换器)
     */
    @Test
    public void customTransform(){
        //判别式
        Predicate<Employee> isLow = new Predicate<Employee>() {

            @Override
            public boolean evaluate(Employee emp) {
                return emp.getSalary() < 10000;
            }

        };
        Predicate<Employee> isHigh = new Predicate<Employee>() {

            @Override
            public boolean evaluate(Employee emp) {
                return emp.getSalary() >= 10000;
            }

        };
        Predicate[] pres = {isLow, isHigh};

        //转换
        Transformer<Employee, Level> lowTrans = new Transformer<Employee, Level>() {

            @Override
            public Level transform(Employee input) {
                return new Level(input.getName(), "卖身中");
            }
        };

        Transformer<Employee, Level> highTrans = new Transformer<Employee, Level>() {

            @Override
            public Level transform(Employee input) {
                return new Level(input.getName(), "养身中");
            }
        };
        Transformer[] trans = {lowTrans, highTrans};

        // 二者进行了关联, 不匹配的部分会被转换成 null
        Transformer switchTrans = new SwitchTransformer(pres, trans, null);

        List<Employee> list = new ArrayList<Employee>();
        list.add(new Employee("老马", 1000000));
        list.add(new Employee("老裴", 999));

        Collection<Level> levelList = CollectionUtils.collect(list, switchTrans);

        Iterator<Level> levelIt = levelList.iterator();
        while (levelIt.hasNext()) {
            System.out.println(levelIt.next());
        }
    }

    /**
     * 内置类型的转换
     * 长整形时间日期，转成指定格式的字符串
     */
    @Test
    public void innerTransform() {
        Transformer<Long, String> trans = new Transformer<Long, String>() {
            @Override
            public String transform(Long input) {
                return new SimpleDateFormat("yyyy年MM月dd日").format(input);
            }
        };

        List<Long> list = new ArrayList<Long>();
        list.add(999999999999L);
        list.add(300000000L);

        Collection<String> result = CollectionUtils.collect(list, trans);
        for (String time : result) {
            System.out.println(time);
        }
    }
}
