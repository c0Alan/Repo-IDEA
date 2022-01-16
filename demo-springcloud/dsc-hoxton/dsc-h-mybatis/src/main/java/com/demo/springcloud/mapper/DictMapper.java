package com.demo.springcloud.mapper;

import com.demo.springcloud.entity.Dict;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DictMapper {
    int insert(Dict record);

    int insertSelective(Dict record);

    int batchInsert(List<Dict> dictList);

    /**
     * 获取当前系统字典id值
     * @return
     */
    int getCurrentSysDictId();

}