package com.mybatis.mapper2;

import com.mybatis.model.Address;
import org.apache.ibatis.annotations.Select;

public interface AddressMapper {

    @Select("select * from springdemo.address where id=#{id}")
    public Address findById(Integer id);

}