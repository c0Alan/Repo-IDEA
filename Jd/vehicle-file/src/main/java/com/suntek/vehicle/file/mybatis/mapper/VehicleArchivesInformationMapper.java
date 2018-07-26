package com.suntek.vehicle.file.mybatis.mapper;


import com.suntek.vehicle.file.entity.VehicleArchivesInformation;

public interface VehicleArchivesInformationMapper {

    int insert(VehicleArchivesInformation record);

    int insertSelective(VehicleArchivesInformation record);

    VehicleArchivesInformation selectByXh(String xh);

    Integer selectCount(String xh);
}