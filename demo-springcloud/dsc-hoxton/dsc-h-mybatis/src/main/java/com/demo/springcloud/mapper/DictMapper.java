package com.demo.springcloud.mapper;

import com.demo.springcloud.entity.Dict;

public interface DictMapper {
    int insert(Dict record);

    int insertSelective(Dict record);
}