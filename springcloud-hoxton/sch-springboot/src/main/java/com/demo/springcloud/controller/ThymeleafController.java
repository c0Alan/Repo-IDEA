package com.demo.springcloud.controller;

import com.demo.springcloud.entity.SysUser;
import com.demo.springcloud.service.impl.SysUserServiceImpl;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * thymeleaf 接口示例
 * 参考：https://blog.csdn.net/chenyunjiangNN/article/details/127141633
 * 参考：https://cloud.tencent.com/developer/article/1522712
 *
 * @author liuxl
 * @date 2024/9/17
 */
@Api(tags = "thymeleaf接口示例")
@Controller
@RequestMapping("/thymeleaf")
public class ThymeleafController {

    @Autowired
    private SysUserServiceImpl sysUserService;


    /**
     * 转发到templates 下面的 thymeleaf.html
     */
    @GetMapping("/thymeleaf")
    public String thymeleaf(Model model) {
        //向请求作用域中写入数据
        model.addAttribute("data", "thymeleaf 示例");
        //返回视图
        return "thymeleaf";
    }

    /**
     * 转发到 static 下面的 thymeleaf.html
     */
    @GetMapping("/thymeleaf2")
    public void thymeleaf2(HttpServletResponse response) throws IOException {
        response.sendRedirect("/thymeleaf");
    }

    /**
     * 用户列表
     */
    @GetMapping("/userList")
    public String userList(Model model) {
        List<SysUser> list = sysUserService.list();
        model.addAttribute("userList", list);
        return "userList";
    }

    /**
     * 用户注册
     */
    @GetMapping("/userForm")
    public String userForm(Model model) {
        return "userForm";
    }

    

    @GetMapping(value = "/user/create")
    public String createUserForm(ModelMap map) {
        map.addAttribute("user", new SysUser());
        map.addAttribute("action", "create");
        return "userForm";
    }

    @PostMapping(value = "/user/create")
    public String saveUser(@ModelAttribute SysUser user) {
        sysUserService.saveEncrypt(user);
        return "redirect:/thymeleaf/userList";
    }

    @GetMapping(value = "/user/update/{id}")
    public String edit(@PathVariable Long id, Model model) {
        model.addAttribute("user", sysUserService.getById(id));
        model.addAttribute("action", "update");
        return "userForm";
    }

    @PostMapping(value = "/user/update")
    public String updateUser(@ModelAttribute SysUser user) {
        user.setPassword(null);
        sysUserService.updateById(user);
        return "redirect:/thymeleaf/userList";
    }

    @GetMapping(value = "/user/delete/{id}")
    public String deleteUserById(@PathVariable Long id) {
        sysUserService.removeById(id);
        return "redirect:/thymeleaf/userList";
    }
}
