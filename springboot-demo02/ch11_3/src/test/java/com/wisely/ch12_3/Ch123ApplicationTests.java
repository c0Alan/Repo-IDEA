package com.springboot.ch12_3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.springboot.ch11_3.Ch123Application;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Ch123Application.class)
public class Ch123ApplicationTests {

	@Test
	public void contextLoads() {
	}

}
