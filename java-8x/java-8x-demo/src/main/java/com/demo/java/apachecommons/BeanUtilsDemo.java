package com.demo.java.apachecommons;

import com.demo.java.entity.Person;
import com.demo.java.entity.Student;
import org.apache.commons.beanutils.BeanUtils;
import org.junit.Test;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * apache commons beanutils
 * 参考：https://segmentfault.com/a/1190000044502408
 * 
 * @author liuxl
 * 2017-9-28 下午4:58:34
 */
public class BeanUtilsDemo {


    /**
     * 测试 PropertyUtils 类
     */
    @Test
    public void test01() throws Exception{
        
        Person p = new Person(1, "Tom", 20, Date.valueOf("1992-11-10"));
        Student s = new Student();
        
        /** copyProperties: 对象属性的复制, 如果存在名称不相同的属性，则BeanUtils不对这些属性进行处理, 提供类型转换功能 */
        BeanUtils.copyProperties(s, p);
        System.out.println(s);
        
        p = new Person();
        List<String> phones = new ArrayList<String>();
        phones.add("12120000");
        phones.add("12130000");
        
        /** copyProperty: 单个属性赋值 */
        BeanUtils.copyProperty(p, "telephone", phones);
        System.out.println(p);
        
        Map<String, String> addresses = new HashMap<String, String>();
        addresses.put("1", "北京");
        addresses.put("2", "上海");
        BeanUtils.copyProperty(p, "address", addresses);
        System.out.println(p);

        // 报错, 日期转换错误
        /*DateConverter converter = new DateConverter();
        converter.setPattern("yyyy-MM-dd");
        ConvertUtils.register(converter, Date.class);*/

        Map<String, String> map = new HashMap<>();
        map.put("name", "Jim");
        /** java.util.Date类型无法转换, 只能转换 java.sql.Date */
        map.put("birthday", "1992-11-10");
        BeanUtils.copyProperties(p, map);
        System.out.println(p);
        
        /** getProperty: 获取属性的值 */
//        String telephone1 = BeanUtils.getProperty(p, "telephone[1]");
//        String address1 = BeanUtils.getProperty(p, "address(1)");
        
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("name", "Jimmy");
        map2.put("birthday", "1995-11-10");
        
        /** 同 copyProperties, populate: 对象属性的复制, 如果存在名称不相同的属性，则BeanUtils不对这些属性进行处理, 提供类型转换功能 */
        BeanUtils.populate(p, map2);
        System.out.println(p);
        
    }
    

}
