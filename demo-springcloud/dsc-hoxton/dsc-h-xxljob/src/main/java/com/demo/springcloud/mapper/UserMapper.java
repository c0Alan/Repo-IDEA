package com.demo.springcloud.mapper;

import com.demo.springcloud.entity.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    int insert(User record);

    int insertSelective(User record);

    public List<User> listUserByAge(int age);

    @Select("select * from t_user where id=#{id}")
    public User getUserById(int id);

    @Delete("delete from t_user where id=#{id}")
    public int deleteUserById(int id);

}