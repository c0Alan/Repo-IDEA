package com.demo.springcloud.dao;

import com.demo.springcloud.entity.TestStudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.sql.Date;
import java.util.List;

@Repository
public interface StudentDao extends JpaRepository<TestStudentEntity, Integer> {

    List<TestStudentEntity> findByName(String name);

    List<TestStudentEntity> findByBirthdayAfter(Date birthday);

    @Modifying
    @Query(value = "update TestStudentEntity stu set stu.remark = ?1 where stu.id = ?2")
    void updateRemarkById(String remark, int id);


}
