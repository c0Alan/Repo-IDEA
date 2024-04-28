package com.commons.model;

/**
 * 学生 bean
 * 
 * @author liuxl
 * 2017-9-28 下午5:03:24
 */
public class Student {
    /** id */
    private Integer id;

    /** 姓名 */
    private String name;

    /** 年龄 */
    private Integer age;

    /** 年级 */
    private Integer grade;

    /** 班级 */
    private Integer classes;

    /** 生日 */
    private String birthday;

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

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getClasses() {
        return classes;
    }

    public void setClasses(Integer classes) {
        this.classes = classes;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age + ", grade=" + grade + ", classes=" + classes
                + ", birthday=" + birthday + "]";
    }

}
