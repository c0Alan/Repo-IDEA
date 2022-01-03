package com.demo.springcloud.mapper;

import com.demo.springcloud.entity.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface DeptMapper {
    int insert(Dept record);

    int insertSelective(Dept record);

    @Select("select * from t_dept where id=#{id}")
    public Dept getDeptById(int id);

}