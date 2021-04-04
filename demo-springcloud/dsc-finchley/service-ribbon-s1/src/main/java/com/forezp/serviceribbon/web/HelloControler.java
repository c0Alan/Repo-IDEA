package com.forezp.serviceribbon.web;

import com.forezp.serviceribbon.service.HelloService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Email miles02@163.com
 *
 * @author fangzhipeng
 * create 2018-07-09
 **/
@RestController
public class HelloControler {

    @Autowired
    HelloService helloService;

    @ApiOperation(value="hiService", notes="hiService")
    @ApiImplicitParam(name = "name", value = "name", required = true, dataType = "String", paramType = "query")
    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name) {
        return helloService.hiService( name );
    }
}
