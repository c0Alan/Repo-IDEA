package com.mybatis.demo01.mapper;

import com.mybatis.model.Address;

public interface AddressMapper {

    public Address findById(Integer id);

}