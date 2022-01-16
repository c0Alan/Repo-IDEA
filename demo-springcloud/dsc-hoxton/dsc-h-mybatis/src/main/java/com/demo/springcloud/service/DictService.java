package com.demo.springcloud.service;

import com.demo.springcloud.entity.Dept;
import com.demo.springcloud.entity.Dict;

import java.util.List;

public interface DictService {

    /**
     * 获取当前系统字典id值
     * @return
     */
    int getCurrentSysDictId();

    int saveDictList(List<Dict> dictList);

}
