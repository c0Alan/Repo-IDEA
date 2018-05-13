package com.mybatis.test;

import com.mybatis.mapper.StudentMapper;
import com.mybatis.model.Student;
import com.mybatis.util.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

public class StudentTest {

    private static Logger logger = Logger.getLogger(StudentTest.class);

    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionFactoryUtil.openSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student("李四", 11);
        int result = studentMapper.add(student);
        sqlSession.commit();
        if (result > 0) {
            logger.info("添加成功！");
        }
    }
}