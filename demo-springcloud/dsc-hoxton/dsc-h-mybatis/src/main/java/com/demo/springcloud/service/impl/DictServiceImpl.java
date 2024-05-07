package com.demo.springcloud.remote.impl;

import com.demo.springcloud.entity.Dict;
import com.demo.springcloud.mapper.DictMapper;
import com.demo.springcloud.remote.DictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("dictService")
public class DictServiceImpl implements DictService {
    @Autowired
    DictMapper dictMapper;

    @Override
    public int getCurrentSysDictId() {
        return dictMapper.getCurrentSysDictId();
    }

    @Override
    public int saveDictList(List<Dict> dictList) {
        return dictMapper.batchInsert(dictList);
    }
}
