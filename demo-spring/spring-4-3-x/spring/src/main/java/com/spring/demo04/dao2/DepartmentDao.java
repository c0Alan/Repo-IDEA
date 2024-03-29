package com.spring.demo04.dao2;

import com.spring.domain.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/**
 * 不推荐使用 JdbcDaoSupport, 而推荐直接使用 JdbcTempate 作为 Dao 类的成员变量
 */
@Repository
public class DepartmentDao extends JdbcDaoSupport {

    @Autowired
    public void setDataSource2(DataSource dataSource) {
        setDataSource(dataSource);
    }

    public Department get(Integer id) {
        String sql = "SELECT id, dept_name as name FROM springdemo.department WHERE id = ?";
        RowMapper<Department> rowMapper = new BeanPropertyRowMapper<>(Department.class);
        return getJdbcTemplate().queryForObject(sql, rowMapper, id);
    }

}
