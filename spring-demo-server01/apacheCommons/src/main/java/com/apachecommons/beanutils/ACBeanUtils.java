package com.apachecommons.beanutils;

import java.lang.reflect.InvocationTargetException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.log4j.Logger;

import com.commons.model.Person;
import com.commons.model.Student;


/**
 * apache commons beanutils 包测试类
 * 
 * @author liuxl
 * 2017-9-28 下午4:58:34
 */
public class ACBeanUtils {
    private static Logger logger = Logger.getLogger(ACBeanUtils.class);
    
    /**
     * 测试 PropertyUtils 类
     * 
     * 2017-9-28 下午5:04:31
     * @throws InvocationTargetException 
     * @throws IllegalAccessException 
     * @throws NoSuchMethodException 
     */
    public void testPropertyUtils() throws Exception{
        
        Person p = new Person(1, "Tom", 20, Date.valueOf("1992-11-10"));
        Student s = new Student();
        
        /** copyProperties: 对象属性的复制, 如果存在名称不相同的属性，则BeanUtils不对这些属性进行处理, 提供类型转换功能 */
        /** java.util.Date类型无法转换, 只能转换 java.sql.Date */
        BeanUtils.copyProperties(s, p);
        
        p = new Person();
        Map<String, String> map = new HashMap<String, String>();
        map.put("name", "Jim");
        map.put("birthday", "1992-11-10");
        
        List<String> phones = new ArrayList<String>();
        phones.add("12120000");
        phones.add("12130000");
        
        /** copyProperty: 单个属性赋值 */
        BeanUtils.copyProperty(p, "telephone", phones);
        
        Map<String, String> addresses = new HashMap<String, String>();
        addresses.put("1", "北京");
        addresses.put("2", "上海");
        BeanUtils.copyProperty(p, "address", addresses);
        BeanUtils.copyProperties(p, map);
        
        /** getProperty: 获取属性的值 */
//        String telephone1 = BeanUtils.getProperty(p, "telephone[1]");
//        String address1 = BeanUtils.getProperty(p, "address(1)");
        
        Map<String, String> map2 = new HashMap<String, String>();
        map2.put("name", "Jimmy");
        map2.put("birthday", "1995-11-10");
        
        /** 同 copyProperties, populate: 对象属性的复制, 如果存在名称不相同的属性，则BeanUtils不对这些属性进行处理, 提供类型转换功能 */
        BeanUtils.populate(p, map2);
        
    }
    
    public void test(){
        logger.info("test");
    }
    
}
