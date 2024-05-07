package com.demo.springcloud.remote.impl;

import com.demo.springcloud.entity.Dept;
import com.demo.springcloud.mapper.DeptMapper;
import com.demo.springcloud.remote.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("deptService")
public class DeptServiceImpl implements DeptService {

    @Autowired
    DeptMapper deptMapper;

    @Override
    public Dept queryDept(int id) {
        return deptMapper.getDeptById(id);
    }
}
