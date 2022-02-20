package com.demo.springcloud.controller;

import com.demo.springcloud.entity.Address;
import com.demo.springcloud.service.AddressService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 地址相关接口
 * @author liuxilin
 * @date 2022/2/7 22:43
 */
@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    private AddressService addressService;


    /**
     * 批量新增地址
     * @param addressList
     * @return
     */
    @ApiOperation(value="批量新增地址", notes = "批量新增地址")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "addressList", value = "json对象", required = true, paramType = "body")
    })
    @PostMapping("/saveAddressList")
    public int saveAddressList(@RequestBody List<Address> addressList){
        return addressService.saveAddressList(addressList);
    }
}
