package com.demo.springcloud;

import com.demo.springcloud.mapper.SysUserMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MysqlTest {
	@Autowired
    SysUserMapper sysUserMapper;

	@Test
	public void contextLoads() {
		System.out.println("test run");
	}

	@Test
	public void test() {
		System.out.println(sysUserMapper.selectById(1));
	}

}
