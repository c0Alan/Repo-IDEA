package com.demo.springcloud.controller;

import com.demo.springcloud.entity.User;
import com.demo.springcloud.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 新增数据
     */
    @GetMapping("/save")
    public String save() {

        int row = userService.saveUser();
        //判断结果
        if (row == -1) {
            return "新增失败";
        } else {
            return "新增成功";
        }
    }

    /**
     * 查询数据
     */
    @GetMapping("/query")
    public String query() {
        //查寻数据
        List list = userService.queryAllUser();
        //组装数据
        List newlist = new ArrayList();
        //循环取出结果
        for (int i = 0; i < list.size(); i++) {
            //新建学生对象
            User user = (User) list.get(i);
            //填充数据
            newlist.add(user.getId());
            newlist.add(user.getUsername());
            newlist.add(user.getAge());
        }
        //返回数据
        return newlist.toString();
    }


    /**
     * 更新数据
     */
    @GetMapping("/update")
    public String update() {
        //新建对象传递数据
        User user = new User();
        user.setId(2);
        user.setUsername("尼古拉斯");
        user.setAge(23);
        //执行更新操作
        int row = userService.updateUser(user);
        //判断结果
        if (row == -1) {
            return "更新失败";
        } else {
            return "更新成功";
        }
    }

    /**
     * 删除数据
     */
    @GetMapping("/delete")
    public String delete() {
        //初始化数据
        Integer id = 3;
        //执行删除
        int row = userService.deleteUser(id);
        //判断结果
        if (row == -1) {
            return "删除失败";
        } else {
            return "删除成功";
        }
    }

}
