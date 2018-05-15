package com.mybatis.mapper2;

import com.mybatis.model.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface StudentMapper {

    @Insert("insert into springdemo.student(name, age) values(#{name},#{age})")
    public int insertStudent(Student student);
    
    @Update("update springdemo.student set name=#{name},age=#{age} where id=#{id}")
    public int updateStudent(Student student);
    
    @Delete("delete from springdemo.student where id=#{id}")
    public int deleteStudent(int id);
    
    @Select("select * from springdemo.student where id=#{id}")
    public Student getStudentById(Integer id);
    
    @Select("select * from springdemo.student")
    @Results(
            {
                @Result(id=true,column="id",property="id"),
                @Result(column="name",property="name"),
                @Result(column="age",property="age")
            }
    )
    public List<Student> findStudents();
    
    @Select("select * from springdemo.student where id=#{id}")
    @Results(
            {
                @Result(id=true,column="id",property="id"),
                @Result(column="name",property="name"),
                @Result(column="age",property="age"),
                @Result(column="address_id",property="address",one=@One(select="com.mybatis.mapper2.AddressMapper.findById"))
            }
    )
    public Student selectStudentWithAddress(int id);
    
    @Select("select * from springdemo.student where grade_id=#{gradeId}")
    @Results(
            {
                @Result(id=true,column="id",property="id"),
                @Result(column="name",property="name"),
                @Result(column="age",property="age"),
                @Result(column="grade_id",property="grade",one=@One(select="com.mybatis.mapper2.GradeMapper.findById"))
            }
    )
    public Student selectStudentByGradeId(int gradeId);
    
    @Select("select * from springdemo.student where id=#{id}")
    @Results(
            {
                @Result(id=true,column="id",property="id"),
                @Result(column="name",property="name"),
                @Result(column="age",property="age"),
                @Result(column="address_id",property="address",one=@One(select="com.mybatis.mapper2.AddressMapper.findById")),
                @Result(column="grade_id",property="grade",one=@One(select="com.mybatis.mapper2.GradeMapper.findById"))
            }
    )
    public Student selectStudentWithAddressAndGrade(int id);
}