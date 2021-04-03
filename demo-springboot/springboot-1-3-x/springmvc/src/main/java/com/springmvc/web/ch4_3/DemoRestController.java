package com.springmvc.web.ch4_3;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.domain.DemoObj;

/**
 * 使用@RestController ，声明是控制器，并且返回数据时不需要 @ResponseBody.
 * 返回数据的媒体类型为json , 直接返回对象，对象会自动转换成json
 * 返回数据的媒体类型为xml, 直接返回对象，对象会自动转换为xml
 * 注意: 用@RestController注解的类, 无法返回视图, 即无法重定向, 或转发
 *
 * @author liuxilin
 * @date 2018/6/11 20:10
 */
@RestController //1
@RequestMapping("/rest")
public class DemoRestController {

    @RequestMapping(value = "/getjson",
            produces = {"application/json;charset=UTF-8"}) //2
    public DemoObj getjson(DemoObj obj) {
        return new DemoObj(obj.getId() + 1, obj.getName() + "yy");//3
    }

    @RequestMapping(value = "/getxml",
            produces = {"application/xml;charset=UTF-8"})//4
    public DemoObj getxml(DemoObj obj) {
        return new DemoObj(obj.getId() + 1, obj.getName() + "yy");
    }

}
