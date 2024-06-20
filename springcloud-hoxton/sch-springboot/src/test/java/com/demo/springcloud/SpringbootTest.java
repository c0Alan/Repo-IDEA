package com.demo.springcloud;


import com.demo.springcloud.config.AppTestConfig;
import com.demo.springcloud.config.Config01;
import com.demo.springcloud.config.Config02;
import com.demo.springcloud.controller.DemoController;
import com.demo.springcloud.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.http.Cookie;

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

	@Autowired
	DemoController demoController;

	private MockMvc mock;

	@Autowired
	private WebApplicationContext wac;

	@Before
	public void setUp() {
		mock = MockMvcBuilders.webAppContextSetup(wac).build();
	}


	@Test
	public void contextLoads() {
		System.out.println("test run!");
	}

	@Test
	public void mvcGet() throws Exception {
		/*ResultActions actions = mock.perform(MockMvcRequestBuilders.get("/demo/users/1")
				.header("X-Access-Token", "0123456789")
				.cookie(new Cookie("cookie", "123456789"))
				.param("a", "1")
				.param("b", "2"));*/

		ResultActions actions = mock.perform(MockMvcRequestBuilders.get("/demo/users/1"));

		// 期望请求成功
		actions.andExpect(MockMvcResultMatchers.status().isOk());
		// 打印请求头
		actions.andDo(MockMvcResultHandlers.print());

		MvcResult result = actions.andReturn();
		// 断言
		Assert.assertTrue(result.getResponse().isCommitted());
	}

	/**
	 * aop 测试
	 */
	@Test
	public void test02() {
		SysUser user = demoController.getUser(3);
		log.info("user: " + user);
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
