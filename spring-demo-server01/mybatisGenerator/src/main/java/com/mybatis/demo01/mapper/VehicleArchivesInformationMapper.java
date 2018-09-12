package com.mybatis.demo01.mapper;

import com.mybatis.model.VehicleArchivesInformation;

public interface VehicleArchivesInformationMapper {
    int insert(VehicleArchivesInformation record);

    int insertSelective(VehicleArchivesInformation record);
}