package com.demo.springcloud.service;

import com.demo.springcloud.entity.TestStudentEntity;

import java.util.List;

public interface IStudentService {

    TestStudentEntity findById(Integer id);

    List<TestStudentEntity> findAll();

    List<TestStudentEntity> findByName(String name);

    TestStudentEntity save(TestStudentEntity student);

    void delete(Integer id);

}
