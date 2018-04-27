package com.springmvc.controller;

import com.springmvc.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;
import java.util.Date;
import java.util.Map;

@SessionAttributes(value={"user"}, types={String.class})
@RequestMapping("/mvc")
@Controller
public class SpringMVCDemo1 {

    private static final String SUCCESS = "success";
    
    @RequestMapping("/testRedirect")
    public String testRedirect(){
        System.out.println("testRedirect");
        return "redirect:/test.jsp";
    }
    
    @RequestMapping("/testView")
    public String testView(){
        System.out.println("testView");
        return "helloView";
    }
    
    @RequestMapping("/testViewAndViewResolver")
    public String testViewAndViewResolver(){
        System.out.println("testViewAndViewResolver");
        return SUCCESS;
    }
    
    /**
     * 1. 有 @ModelAttribute 标记的方法, 会在每个目标方法执行之前被 SpringMVC 调用! 
     * 2. @ModelAttribute 注解也可以来修饰目标方法 POJO 类型的入参, 其 value 属性值有如下的作用:
     * 1). SpringMVC 会使用 value 属性值在 implicitModel 中查找对应的对象, 若存在则会直接传入到目标方法的入参中.
     * 2). SpringMVC 会一 value 为 key, POJO 类型的对象为 value, 存入到 request 中. 
     */
    @ModelAttribute
    public void getUser(@RequestParam(value="id",required=false) Integer id,
            Map<String, Object> map){
        System.out.println("modelAttribute method");
        if(id != null){
            //模拟从数据库中获取对象
            User user = new User(1, "Tom", "123456", "tom@atguigu.com", 12);
            System.out.println("从数据库中获取一个对象: " + user);
            
            map.put("user", user);
        }
    }
    
    /**
     * 运行流程:
     * 1. 执行 @ModelAttribute 注解修饰的方法: 从数据库中取出对象, 把对象放入到了 Map 中. 键为: user
     * 2. SpringMVC 从 Map 中取出 User 对象, 并把表单的请求参数赋给该 User 对象的对应属性.
     * 3. SpringMVC 把上述对象传入目标方法的参数. 
     * 
     */
    @RequestMapping("/testModelAttribute")
    public String testModelAttribute(User user){
        System.out.println("修改: " + user);
        return SUCCESS;
    }
    
    /**
     * @SessionAttributes 除了可以通过属性名指定需要放到会话中的属性外(实际上使用的是 value 属性值),
     * 还可以通过模型属性的对象类型指定哪些模型属性需要放到会话中(实际上使用的是 types 属性值)
     * 
     * 注意: 该注解只能放在类的上面. 而不能修饰放方法. 
     */
    @RequestMapping("/testSessionAttributes")
    public String testSessionAttributes(Map<String, Object> map){
        User user = new User("Tom", "123456", "tom@atguigu.com", 15);
        map.put("user", user);
        map.put("school", "atguigu");
        return SUCCESS;
    }
    
    /**
     * 目标方法可以添加 Map 类型(实际上也可以是 Model 类型或 ModelMap 类型)的参数. 
     * @param map
     * @return
     */
    @RequestMapping("/testMap")
    public String testMap(Map<String, Object> map){
        System.out.println(map.getClass().getName()); 
        map.put("names", Arrays.asList("Tom", "Jerry", "Mike"));
        return SUCCESS;
    }
    
    /**
     * 目标方法的返回值可以是 ModelAndView 类型。 
     * 其中可以包含视图和模型信息
     * SpringMVC 会把 ModelAndView 的 model 中数据放入到 request 域对象中.
     * @return
     */
    @RequestMapping("/testModelAndView")
    public ModelAndView testModelAndView(){
        String viewName = SUCCESS;
        ModelAndView modelAndView = new ModelAndView(viewName);
        
        //添加模型数据到 ModelAndView 中.
        modelAndView.addObject("time", new Date());
        
        return modelAndView;
    }
    
    /**
     * 可以使用 Serlvet 原生的 API 作为目标方法的参数 具体支持以下类型
     * 
     * HttpServletRequest 
     * HttpServletResponse 
     * HttpSession
     * java.security.Principal 
     * Locale InputStream 
     * OutputStream 
     * Reader 
     * Writer
     * @throws IOException 
     */
    @RequestMapping("/testServletAPI")
    public void testServletAPI(HttpServletRequest request,
                               HttpServletResponse response, Writer out) throws IOException {
        System.out.println("testServletAPI, " + request + ", " + response);
        out.write("hello springmvc");
//        return SUCCESS;
    }

    /**
     * Spring MVC 会按请求参数名和 POJO 属性名进行自动匹配， 自动为该对象填充属性值。支持级联属性。
     * 如：dept.deptId、dept.address.tel 等
     */
    @RequestMapping("/testPojo")
    public String testPojo(User user) {
        System.out.println("testPojo: " + user);
        return SUCCESS;
    }

    /**
     * 了解:
     * 
     * @CookieValue: 映射一个 Cookie 值. 属性同 @RequestParam
     */
    @RequestMapping("/testCookieValue")
    public String testCookieValue(@CookieValue("JSESSIONID") String sessionId) {
        System.out.println("testCookieValue: sessionId: " + sessionId);
        return SUCCESS;
    }

    /**
     * 了解: 映射请求头信息 用法同 @RequestParam
     */
    @RequestMapping("/testRequestHeader")
    public String testRequestHeader(
            @RequestHeader(value = "Accept-Language") String al) {
        System.out.println("testRequestHeader, Accept-Language: " + al);
        return SUCCESS;
    }

    /**
     * @RequestParam 来映射请求参数. value 值即请求参数的参数名 required 该参数是否必须. 默认为 true
     *               defaultValue 请求参数的默认值
     */
    @RequestMapping(value = "/testRequestParam")
    public String testRequestParam(
            @RequestParam(value = "username") String un,
            @RequestParam(value = "age", required = false, defaultValue = "0") int age) {
        System.out.println("testRequestParam, username: " + un + ", age: "
                + age);
        return SUCCESS;
    }

    /**
     * 新增: /order POST
     * 修改: /order/1 PUT update?id=1
     * 获取: /order/1 GET get?id=1
     * 删除: /order/1 DELETE delete?id=1
     * 
     * 如何发送 PUT 请求和 DELETE 请求呢 ? 1. 需要配置 HiddenHttpMethodFilter
     * 2. 需要发送 POST 请求
     * 3. 需要在发送 POST 请求时携带一个 name="_method" 的隐藏域, 值为 DELETE 或 PUT
     * 在 SpringMVC 的目标方法中如何得到 id 呢? 使用 @PathVariable 注解
     * 
     */
    @ResponseBody
    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.PUT)
    public String testRestPut(@PathVariable Integer id) {
        System.out.println("testRest Put: " + id);
        return SUCCESS;
    }

    /**
     * JSPs only permit GET POST or HEAD
     * 加 @ResponseBody 解决上面问题
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.DELETE)
    public String testRestDelete(@PathVariable Integer id) {
        System.out.println("testRest Delete: " + id);
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest", method = RequestMethod.POST)
    public String testRest() {
        System.out.println("testRest POST");
        return SUCCESS;
    }

    @RequestMapping(value = "/testRest/{id}", method = RequestMethod.GET)
    public String testRest(@PathVariable Integer id) {
        System.out.println("testRest GET: " + id);
        return SUCCESS;
    }

    /**
     * @PathVariable 可以来映射 URL 中的占位符到目标方法的参数中.
     * @param id
     * @return
     */
    @RequestMapping("/testPathVariable/{id}")
    public String testPathVariable(@PathVariable("id") Integer id) {
        System.out.println("testPathVariable: " + id);
        return SUCCESS;
    }

    @RequestMapping("/testAntPath/*/abc")
    public String testAntPath() {
        System.out.println("testAntPath");
        return SUCCESS;
    }

    /**
     * 了解: 可以使用 params 和 headers 来更加精确的映射请求. params 和 headers 支持简单的表达式.
     * 
     * @return
     */
    @RequestMapping(value = "testParamsAndHeaders", params = { "username",
            "age!=10" }, headers = { "Accept-Language=zh-CN,zh;q=0.8,en;q=0.6,zh-TW;q=0.4,ja;q=0.2" })
    public String testParamsAndHeaders() {
        System.out.println("testParamsAndHeaders");
        return SUCCESS;
    }

    /**
     * 常用: 使用 method 属性来指定请求方式
     */
    @RequestMapping(value = "/testMethod", method = RequestMethod.POST)
    public String testMethod() {
        System.out.println("testMethod");
        return SUCCESS;
    }

    /**
     * 测试 RequestMapping
     * @return
     */
    @RequestMapping("/testRequestMapping")
    public String testRequestMapping() {
        System.out.println("testRequestMapping");
        return SUCCESS;
    }

}