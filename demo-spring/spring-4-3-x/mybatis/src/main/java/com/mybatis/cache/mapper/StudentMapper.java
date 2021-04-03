package com.mybatis.cache.mapper;

import com.mybatis.model.Student;

public interface StudentMapper {

    public int add(Student student);
    
    public Student findById(Integer id);

    public void update(Student student);

}