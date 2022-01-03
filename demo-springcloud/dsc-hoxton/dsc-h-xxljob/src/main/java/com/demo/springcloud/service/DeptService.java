package com.demo.springcloud.service;

import com.demo.springcloud.entity.Dept;

public interface DeptService {

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    public Dept queryDept(int id);

}
