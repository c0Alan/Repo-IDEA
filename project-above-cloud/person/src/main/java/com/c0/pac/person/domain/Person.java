package com.c0.pac.person.domain;


import javax.persistence.*;

@Entity
@Table(name = "person", schema = "springdemo", catalog = "sd")
public class Person {
    @Id
    @SequenceGenerator(name = "TD_NOTIFY_FDSEQ_GENERATOR",
            sequenceName = "springdemo.NOTIFY_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE,
            generator = "TD_NOTIFY_FDSEQ_GENERATOR")
    private Long id;

    private String name;

    private Integer age;

    private String address;

    public Person(){

    }

    public Person(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
