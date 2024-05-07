package com.demo.springcloud.remote;

import com.demo.springcloud.entity.Address;

import java.util.List;

/**
 *
 * @author liuxilin
 * @date 2022/2/7 12:19
 */
public interface AddressService {


    /**
     *
     * @param addressList
     * @return
     */
    int saveAddressList(List<Address> addressList);

}
