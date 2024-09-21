package com.demo.springcloud.entity;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;

/**
 * @author liuxl
 * @date 2024/9/15
 */
@Data
@Entity
@Table(name = "test_student")
public class TestStudentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    
    @Column(name = "name")
    private String name;
    
    @Column(name = "sex")
    private Integer sex;
    
    @Column(name = "birthday")
    private Date birthday;
    
    @Column(name = "remark")
    private String remark;
    
    @Column(name = "create_time")
    private Timestamp createTime;
    
    @Column(name = "update_time")
    private Timestamp updateTime;

}
