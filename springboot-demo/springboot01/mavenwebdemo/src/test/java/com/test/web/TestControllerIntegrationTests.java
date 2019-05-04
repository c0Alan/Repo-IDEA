package com.test.web;


import com.test.MyMvcConfig;
import com.test.service.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {MyMvcConfig.class})
@WebAppConfiguration("src/main/resources") // 指定的是Web 资源的位置，默认为src/main/webapp ，本例修改为src/mainlresources .
public class TestControllerIntegrationTests {
    private MockMvc mockMvc; // 模拟MVC对象

    @Autowired
    private DemoService demoService;// 可以在测试用例中注入Spring 的Bean

    @Autowired
    WebApplicationContext wac; // 可注入WebApplicationContext.

    @Autowired
    MockHttpSession session; // 模拟的http session

    @Autowired
    MockHttpServletRequest request; //6

    @Before // 在测试开始前进行的初始化工作。
    public void setup() {
        mockMvc =
                MockMvcBuilders.webAppContextSetup(this.wac).build(); //2
    }

    @Test
    public void testNormalController() throws Exception {
        mockMvc.perform(get("/normal")) // 模拟向/normal 进行get 请求。
                .andExpect(status().isOk())// 预期控制返回状态为200.
                .andExpect(view().name("page"))//10
                .andExpect(forwardedUrl("/WEB-INF/classes/views/page.jsp"))//11
                .andExpect(model().attribute("msg", demoService.saySomething()));//12

    }

    @Test
    public void testRestController() throws Exception {
        mockMvc.perform(get("/testRest")) //13
                .andExpect(status().isOk())
                .andExpect(content().contentType("text/plain;charset=UTF-8"))//14
                .andExpect(content().string(demoService.saySomething()));// 预期返回值的内容为demoService.saySomething()返回值
    }

}
