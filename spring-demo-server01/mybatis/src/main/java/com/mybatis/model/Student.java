package com.mybatis.model;

public class Student {

    private Integer id;
    private String name;
    private Integer age;
    private Address address;
    private Grade grade;

    private byte[] pic; // picture 大对象
    private String remark;


    public Student() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Student(Integer id, String name, Integer age) {
        super();
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public Student(String name, Integer age) {
        super();
        this.name = name;
        this.age = age;
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

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public byte[] getPic() {
        return pic;
    }

    public void setPic(byte[] pic) {
        this.pic = pic;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", age=" + age
//                + ", address=" + address + ", grade=" + grade + "]";  // 这里会导致打印 grade 的时候死循环
//                + ", address=" + address + "]"; // 容易空指针
                + ", address=" + address + ", grade=" + grade.getGradeName() + "]"; // 容易空指针
//                + "]";
    }

}