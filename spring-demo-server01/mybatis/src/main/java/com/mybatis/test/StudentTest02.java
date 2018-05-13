package com.mybatis.test;

import com.mybatis.mapper.StudentMapper;
import com.mybatis.model.Student;
import com.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * mybatis 标签测试
 * 
 * @author liuxilin
 * @date 2018/5/13 21:58
 */
public class StudentTest02 {

    private static Logger logger = Logger.getLogger(StudentTest02.class);
    private SqlSession sqlSession = null;
    private StudentMapper studentMapper = null;

    /**
     * 测试方法前调用
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        sqlSession = SqlSessionFactoryUtil.openSession();
        studentMapper = sqlSession.getMapper(StudentMapper.class);
    }

    /**
     * 测试方法后调用
     *
     * @throws Exception
     */
    @After
    public void tearDown() throws Exception {
        sqlSession.close();
    }

    /**
     * 测试 if 标签
     */
    @Test
    public void testSearchStudents() {
        logger.info("添加学生(带条件)");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("gradeId", 2);
         map.put("name", "%李%");
        // map.put("age", 11);
        List<Student> studentList = studentMapper.searchStudents(map);
        logger.info(studentList);
    }

    /**
     * 测试 choose when otherwise 标签
     */
    @Test
    public void testSearchStudents2() {
        logger.info("添加学生(带条件)");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("searchBy", "age");
        map.put("gradeId", 2);
        map.put("name", "%李%");
        map.put("age", 11);
        List<Student> studentList = studentMapper.searchStudents2(map);
        logger.info(studentList);
    }

    /**
     * 测试where标签
     */
    @Test
    public void testSearchStudents3() {
        logger.info("添加学生(带条件)");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("gradeId", 2);
        map.put("name", "%李%");
//        map.put("age", 11);
        List<Student> studentList = studentMapper.searchStudents3(map);
        logger.info(studentList);
    }

    /**
     * 测试 trim 标签
     */
    @Test
    public void testSearchStudents4() {
        logger.info("添加学生(带条件)");
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("gradeId", 2);
        // map.put("name", "%李%");
        // map.put("age", 11);
        List<Student> studentList = studentMapper.searchStudents4(map);
        logger.info(studentList);
    }

    /**
     * 测试 foreach 标签
     */
    @Test
    public void testSearchStudents5() {
        logger.info("添加学生(带条件)");
        Map<String, Object> map = new HashMap<String, Object>();
        List<Integer> gradeIds = new ArrayList<Integer>();
//        gradeIds.add(1);
        gradeIds.add(2);
        map.put("gradeIds", gradeIds);
        List<Student> studentList = studentMapper.searchStudents5(map);
        logger.info(studentList);
    }

    /**
     * 测试 set 标签
     */
    @Test
    public void testUpdateStudent() {
        logger.info("更新学生(带条件)");
        Student student = new Student();
        student.setId(1);
        student.setName("张三3");
        student.setAge(13);
        studentMapper.updateStudent(student);
        sqlSession.commit();
    }
}
