package com.demo.springcloud.controller;


import com.demo.springcloud.entity.TestStudentEntity;
import com.demo.springcloud.response.ResponseResult;
import com.demo.springcloud.service.StudentServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@Api(tags = "jpa接口示例")
@RestController
@RequestMapping(value = "/jpa")
public class JpaController {

    @Autowired
    private StudentServiceImpl studentService;

    @GetMapping(value = "/findById/{id}")
    public TestStudentEntity findById(@PathVariable("id") Integer id) {
        return studentService.findById(id);
    }

    @GetMapping(value = "/findAll")
    public List<TestStudentEntity> findAll() {
        return studentService.findAll();
    }

    @GetMapping(value = "/findByName/{name}")
    public List<TestStudentEntity> findByName(@PathVariable("name") String name) {
        return studentService.findByName(name);
    }

    @PostMapping(value = "/save")
    public TestStudentEntity save(@RequestBody TestStudentEntity student) {

        return studentService.save(student);
    }

    @GetMapping(value = "/delete/{id}")
    public ResponseResult delete(@PathVariable("id") Integer id) {
        studentService.delete(id);
        return ResponseResult.success();
    }

    @GetMapping(value = "/findByBirthdayAfter")
    public List<TestStudentEntity> findByBirthdayAfter(@RequestParam Date birthday) {
        return studentService.findByBirthdayAfter(birthday);
    }

    @GetMapping(value = "/updateRemarkById/{id}")
    public ResponseResult updateRemarkById(@PathVariable("id") Integer id, @RequestParam String remark) {

        studentService.updateRemarkById(remark, id);
        return ResponseResult.success();
    }




}
