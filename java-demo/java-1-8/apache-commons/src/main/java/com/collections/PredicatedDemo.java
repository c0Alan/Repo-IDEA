package com.collections;


import com.jd.model.Employee;
import com.jd.model.Level;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Predicate;
import org.apache.commons.collections4.PredicateUtils;
import org.apache.commons.collections4.Transformer;
import org.apache.commons.collections4.functors.EqualPredicate;
import org.apache.commons.collections4.functors.NotNullPredicate;
import org.apache.commons.collections4.functors.SwitchTransformer;
import org.apache.commons.collections4.functors.UniquePredicate;
import org.apache.commons.collections4.list.PredicatedList;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * 数据校验, 数据类型转换
 * 正常情况下，会在业务逻辑里面对对象写校验逻辑，
 * 通过实现Predicate实现自动校验，可以使业务操作和校验操作分离
 *
 * @author liuxilin
 * @date 2018/4/21 23:06
 */
public class PredicatedDemo {

    public static void main(String[] args) {

        //自定义校验规则
        Predicate<String> selfPre = new Predicate<String>() {
            @Override
            public boolean evaluate(String object) {
                return object.length() >= 5 && object.length() <= 20;

            }
        };
        Predicate notNull = NotNullPredicate.notNullPredicate();

        // 添加校验规则
        Predicate all = PredicateUtils.allPredicate(notNull, selfPre);

        List<String> list = PredicatedList.predicatedList(new ArrayList<String>(), all);
        list.add("hello");
//        list.add(null); // 报错
//        list.add("bj"); // 报错
        list.add("123456");
        System.out.println("Success !");
    }

    /**
     * 判断唯一
     */
    @Test
    public void unique() {
        Predicate<Long> uniquePre = UniquePredicate.uniquePredicate();
        List<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(), uniquePre);
        list.add(100L);
        list.add(200L);
//        list.add(100L); // 报错
        System.out.println("Success !");
    }

    /**
     * 判断非空
     */
    @Test
    public void notNull() {
        Predicate notNull = NotNullPredicate.notNullPredicate();
        //String str ="bjs";
        String str = null;
        System.out.println(notNull.evaluate(str)); //如果非空为true ,否则为false

        //添加容器值的判断
        List<Long> list = PredicatedList.predicatedList(new ArrayList<Long>(), notNull);
        list.add(1000L);
//        list.add(null); // 验证失败，出现异常
        System.out.println("Success !");
    }


    /**
     * 比较相等判断
     */
    @Test
    public void equal() {
        //Predicate<String> pre = new EqualPredicate<String>("bjsxt");
        Predicate<String> pre = EqualPredicate.equalPredicate("bjsxt");
        boolean flag = pre.evaluate("bjsxt");
        System.out.println(flag);
    }



}
