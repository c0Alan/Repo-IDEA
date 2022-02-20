package com.demo.springcloud.mapper;

import com.demo.springcloud.entity.Address;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AddressMapper {
    int insert(Address record);

    int insertSelective(Address record);

    int batchInsert(List<Address> addressList);

}