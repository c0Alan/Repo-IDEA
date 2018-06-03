package com.mybatis.demo01.mapper;

import com.mybatis.model.Student;
import org.apache.ibatis.session.RowBounds;

import java.util.List;
import java.util.Map;

public interface StudentMapper {

    public int add(Student student);
    
    public int update(Student student);
    
    public int delete(Integer id);
    
    public Student findById(Integer id);
    
    public List<Student> find();
    
    public Student findStudentWithAddress(Integer id);
    
    public Student findByGradeId(Integer gradeId);

    /**
     * 测试 if 标签
     */
    public List<Student> searchStudents(Map<String,Object> map);

    /**
     * 测试 when 标签
     */
    public List<Student> searchStudents2(Map<String,Object> map);

    /**
     * 测试where标签
     */
    public List<Student> searchStudents3(Map<String,Object> map);

    /**
     * 测试 trim 标签
     */
    public List<Student> searchStudents4(Map<String,Object> map);

    /**
     * 测试 foreach 标签
     */
    public List<Student> searchStudents5(Map<String,Object> map);

    public List<Student> searchStudents6(String name,int age);

    public int updateStudent(Student student);

    public int insertStudent(Student student);

    public Student getStudentById(Integer id);

    public List<Student> findStudents(RowBounds rowBounds);

    public List<Student> findStudents2(Map<String,Object> map);

}