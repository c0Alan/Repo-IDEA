package com.demo.java.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;
import java.util.Map;

public class Person implements Serializable {

    private static final long serialVersionUID = 1L;

    private String name;

    /** id */
    private Integer id;

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

    public Person(Date birthday) {
        this.birthday = birthday;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person(String name, Date birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDay() {
        return birthday;
    }

    public void setBirthday(Date birthDay) {
        this.birthday = birthDay;
    }

    @Override
    public String toString() {
        return "Person [id=" + id + ", name=" + name + ", age=" + age + ", birthday=" + birthday + ", telephone="
                + telephone + ", address=" + address + "]";
    }

}
