package com.mybatis.mapper2;

import com.mybatis.model.Grade;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

public interface GradeMapper {

    @Select("select * from springdemo.grade where id=#{id}")
    @Results(
            {
                @Result(id=true,column="id",property="id"),
                @Result(column="grade_name",property="gradeName"),
                @Result(column="id",property="students",many=@Many(select="com.mybatis.mapper2.StudentMapper.selectStudentByGradeId"))
            }
    )
    public Grade findById(Integer id);

}