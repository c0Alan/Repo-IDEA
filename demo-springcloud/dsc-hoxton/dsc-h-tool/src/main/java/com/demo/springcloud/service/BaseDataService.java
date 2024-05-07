package com.demo.springcloud.remote;

import com.demo.springcloud.entity.User;

import java.util.List;
import java.util.Map;

/**
 *
 * @author liuxilin
 * @date 2022/2/7 12:52
 */
public interface BaseDataService {

    String baseDataCache();

    User buildUserData();

    List<User> buildUserList(int size);

    Map buildData(String configFile, int size);
}
