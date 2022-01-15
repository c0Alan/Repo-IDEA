package com.demo.springcloud;

import com.demo.springcloud.controller.FileController;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class FileControllerTests {
	@Autowired
	FileController fileController;

	@Test
	public void contextLoads() {
	}

	@Test
	public void readFileRelativePath(){
		log.info(fileController.readFileRelativePath());
	}

	@Test
	public void readFileAbsolutePath(){
		log.info(fileController.readFileRelativePath());
	}

	@Test
	public void readFileResourcePath(){
		log.info(fileController.readFileRelativePath());
	}

}
