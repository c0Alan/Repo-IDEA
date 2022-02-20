package com.demo.springcloud.service;

import com.demo.springcloud.entity.Address;
import com.demo.springcloud.entity.Dict;
import com.demo.springcloud.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "${app.remote-service.dsc-h-mybatis.service-name}",
url = "${app.remote-service.dsc-h-mybatis.url:}")
public interface MybatisService {
    @GetMapping(value = "/dict/getCurrentSysDictId")
    int getCurrentSysDictId();

    @PostMapping("/dict/saveDictList")
    int saveDictList(List<Dict> dictList);

    @PostMapping("/user/saveUserList")
    int saveUserList(List<User> userList);

    @PostMapping("/address/saveAddressList")
    int saveAddressList(List<Address> addressList);
}
