package com.suntek.auto.operation.service.impl;

import com.suntek.auto.operation.entity.Package;
import com.suntek.auto.operation.mapper.PackageMapper;
import com.suntek.auto.operation.service.PackageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author tantao
 * @version 2018/9/11
 * @Copyright (C)2018 , Suntektech
 * @since
 */
@Service("packageService")
@Transactional(rollbackFor = Exception.class)
public class PackageServiceImpl implements PackageService {

    @Autowired
    private PackageMapper packageMapper;

    public Package uploadPackage(Package packageEntity) {
        return  packageMapper.save(packageEntity);
    }
    
}
