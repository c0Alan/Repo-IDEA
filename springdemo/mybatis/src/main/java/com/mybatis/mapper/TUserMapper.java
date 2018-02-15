package com.mybatis.mapper;

import com.model.mybatis.TUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface TUserMapper {
    int deleteByPrimaryKey(String cId);

    int insert(TUser record);

    int insertSelective(TUser record);

    TUser selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(TUser record);

    int updateByPrimaryKey(TUser record);

    List<TUser> selectAll();

    @Select("SELECT COUNT(1) from springdemo.t_user")
    int selectCount();
}