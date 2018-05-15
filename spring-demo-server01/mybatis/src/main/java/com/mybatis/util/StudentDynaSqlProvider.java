package com.mybatis.util;

import com.mybatis.model.Student;
import org.apache.ibatis.jdbc.SQL;

import java.util.Map;

/**
 * 注解方式动态脚本提供者
 * 
 * @author liuxilin
 * @date 2018/5/15 20:35
 */
public class StudentDynaSqlProvider {

    public String insertStudent(final Student student) {
        return new SQL() {
            {
                INSERT_INTO("springdemo.student");
                if (student.getName() != null) {
                    VALUES("name", "#{name}");
                }
                if (student.getAge() != null) {
                    VALUES("age", "#{age}");
                }
            }
        }.toString();
    }

    public String updateStudent(final Student student) {
        return new SQL() {
            {
                UPDATE("springdemo.student");
                if (student.getName() != null) {
                    SET("name=#{name}");
                }
                if (student.getAge() != null) {
                    SET("age=#{age}");
                }
                WHERE("id=#{id}");
            }
        }.toString();
    }

    public String deleteStudent() {
        return new SQL() {
            {
                DELETE_FROM("springdemo.student");
                WHERE("id=#{id}");
            }
        }.toString();
    }

    public String getStudentById() {
        return new SQL() {
            {
                SELECT("*");
                FROM("springdemo.student");
                WHERE("id=#{id}");
            }
        }.toString();
    }

    /**
     * 纯sql脚本替换, 有 sql 注入风险
     * @param map
     * @return
     */
    public String findStudents(final Map<String, Object> map) {
        return new SQL() {
            {
                SELECT("*");
                FROM("springdemo.student");
                StringBuffer sb = new StringBuffer();
                if (map.get("name") != null) {
                    sb.append(" and name like '" + map.get("name") + "'");
                }
                if (map.get("age") != null) {
                    sb.append(" and age=" + map.get("age"));
                }
                if (!sb.toString().equals("")) {
                    WHERE(sb.toString().replaceFirst("and", ""));
                }
            }
        }.toString();
    }
}