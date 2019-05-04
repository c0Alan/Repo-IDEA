package com.mybatis.demo02.mapper;

import com.mybatis.model.Address;
import org.apache.ibatis.annotations.Select;

public interface AddressMapper {

    @Select("select * from springdemo.address where id=#{id}")
    public Address findById(Integer id);

}