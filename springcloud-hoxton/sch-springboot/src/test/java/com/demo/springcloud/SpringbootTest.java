package com.demo.springcloud;


import com.demo.springcloud.config.AppTestConfig;
import com.demo.springcloud.config.Config01;
import com.demo.springcloud.config.Config02;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootTest {

	@Autowired
	AppTestConfig appTestConfig;

	@Autowired
	Config01 config01;

	@Autowired
	Config02 config02;


	@Test
	public void contextLoads() {
		System.out.println("test run!");
	}

	/**
	 * 配置注入测试
	 */
	@Test
	public void test01() {
		log.info("AppTestConfig: " + appTestConfig);
		log.info("config01: " + config01);
		log.info("config02: " + config02);
	}

}
