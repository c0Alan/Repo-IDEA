package com.webservice.receiver.impl;

import com.webservice.model.Person;
import com.webservice.receiver.PersonService;

import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

/**
 * 类名称：PersonServiceImp.java<br>
 * 类描述：<br>
 * 创建时间：2016年11月11日, 下午2:47:53
 * 
 * @version 1.0 
 * @since JDK版本
 * @author flx 
 */

@WebService(endpointInterface= "com.webservice.receiver.PersonService",serviceName="person")
public class PersonServiceImpl implements PersonService {

	public List<Person> findAll(String name){
        System.out.println("preson servcie has been called!");
        ArrayList<Person> persons = new ArrayList<Person>();
        
        Person p1 = new Person();
        p1.setName(name + "3");
        p1.setAge(18);
        
        Person p2 = new Person();
        p2.setName(name + "4");
        p2.setAge(20);
        
        persons.add(p1);
        persons.add(p2);
        
        return persons;  
    }  
}