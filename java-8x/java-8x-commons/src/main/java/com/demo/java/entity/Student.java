package com.demo.java.entity;


public class Student extends AbstractPerson {


    /** id */
    private Integer id;

    /** 年龄 */
    private Integer age;

    /** 年级 */
    private Integer grade;

    /** 班级 */
    private Integer classes;

    /** 生日 */
    private String birthday;

    /** 专业 */
    private String major;

    @Override
    public String getDescription() {
        return null;
    }

    public Student() {
        super("");
    }

    public Student(String name, String major) {
        // pass n to superclass constructor
        super(name);
        this.major = major;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + super.getName() + ", age=" + age + ", grade=" + grade + ", classes=" + classes
                + ", birthday=" + birthday + "]";
    }
}
