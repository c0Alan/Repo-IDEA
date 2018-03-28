package com.commons.model;

import java.sql.Date;
import java.util.List;
import java.util.Map;

/**
 * 学生 bean
 * 
 * @author liuxl
 * 2017-9-28 下午5:03:24
 */
public class Person {
    /** id */
    private Integer id;

    /** 姓名 */
    private String name;

    /** 年龄 */
    private Integer age;

    /** 生日 */
    private Date birthday;

    /** 电话号码 */
    private List<String> telephone;

    /** 电话号码 */
    private Map<String, String> address;

    public Person(int id, String name, int age, Date birthday) {
        super();
        this.id = Integer.valueOf(id);
        this.name = name;
        this.age = Integer.valueOf(age);
        this.birthday = birthday;
    }

    public Person() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public List<String> getTelephone() {
        return telephone;
    }

    public void setTelephone(List<String> telephone) {
        this.telephone = telephone;
    }

    public Map<String, String> getAddress() {
        return address;
    }

    public void setAddress(Map<String, String> address) {
        this.address = address;
    }

    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + ", birthday=" + birthday + ", telephone="
                + telephone + ", address=" + address + "]";
    }

}
