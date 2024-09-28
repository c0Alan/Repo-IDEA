package com.demo.springcloud.jdbc.impl;

import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.jdbc.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author liuxl
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Resource
    private JdbcTemplate jdbcTemplate;

    @Override
    public int saveUser() {
        String username = "张三";
        int age = 20;
        int row = jdbcTemplate.update("INSERT INTO t_user (username,age)VALUES (?,?);", username, age);
        return row;
    }

    @Override
    public List<SysUser> queryAllUser() {
        //SQL
        String sql = "SELECT *  FROM t_user WHERE username='张三'";

        List<SysUser> list = jdbcTemplate.query(sql, new RowMapper<SysUser>() {
            //映射每行数据  
            @Override
            public SysUser mapRow(ResultSet rs, int rowNum) throws SQLException {
                SysUser user = new SysUser();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                return user;
            }

        });
        return list;
    }

    @Override
    public int updateUser(SysUser SysUser) {

        String sql = "update t_user set username=?,age=? where id=?";

        int row = jdbcTemplate.update(sql, new PreparedStatementSetter() {
            //映射数据
            @Override
            public void setValues(PreparedStatement preparedStatement) throws SQLException {
                preparedStatement.setString(1, SysUser.getUsername());
                preparedStatement.setInt(3, SysUser.getId());
            }
        });

        return row;

    }

    @Override
    public int deleteUser(Integer id) {

        int row = jdbcTemplate.update("delete from t_user WHERE id=?", id);

        return row;
    }
}
