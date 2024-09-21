package com.demo.springcloud.service;


import com.demo.springcloud.dao.StudentDao;
import com.demo.springcloud.entity.TestStudentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private StudentDao studentDao;

    @Override
    public TestStudentEntity findById(Integer id) {
        return studentDao.findById(id).get();
    }

    @Override
    public List<TestStudentEntity> findAll() {
        return studentDao.findAll();
    }

    @Override
    public List<TestStudentEntity> findByName(String name) {
        return studentDao.findByName(name);
    }

    @Override
    @Transactional
    public TestStudentEntity save(TestStudentEntity student) {
        return studentDao.save(student);
    }

    @Override
    @Transactional
    public void delete(Integer id) {
        studentDao.deleteById(id);
    }

    public List<TestStudentEntity> findByBirthdayAfter(Date birthday) {
        return studentDao.findByBirthdayAfter(birthday);
    }

    @Transactional
    public void updateRemarkById(String remark, int id) {
        studentDao.updateRemarkById(remark, id);
    }
}
