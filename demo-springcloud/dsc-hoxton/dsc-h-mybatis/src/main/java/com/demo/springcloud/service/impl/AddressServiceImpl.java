package com.demo.springcloud.service.impl;

import com.demo.springcloud.entity.Address;
import com.demo.springcloud.mapper.AddressMapper;
import com.demo.springcloud.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author liuxilin
 * @date 2022年02月07日 22:44
 */
@Service("addressService")
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper addressMapper;

    @Override
    public int saveAddressList(List<Address> addressList) {
        return addressMapper.batchInsert(addressList);
    }
}
