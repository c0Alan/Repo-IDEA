package com.demo.springcloud;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

/**
 * MockMvc 测试
 * 启动程序执行所有测试用例
 * @author liuxilin
 * @date 2022/2/19 17:31
 */
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceMockMVCTests {

    @Autowired
    protected MockMvc mockMvc;


    @Test
    public void testHello() throws Exception {
        MvcResult mvcResult = mockMvc.perform(
                MockMvcRequestBuilders.get("/helloService/hello3")
                        .param("name", "tom")
                        .accept(MediaType.TEXT_HTML_VALUE))
                //等同于Assert.assertEquals(200,status);
                // .andExpect(MockMvcResultMatchers.status().isOk())
                //等同于 Assert.assertEquals("hello lvgang",content);
                // .andExpect(MockMvcResultMatchers.content().string("hello lvgang"))
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();                 //得到返回代码
        String content = mvcResult.getResponse().getContentAsString();    //得到返回结果
        System.out.println(status);
        System.out.println(content);
    }

}
