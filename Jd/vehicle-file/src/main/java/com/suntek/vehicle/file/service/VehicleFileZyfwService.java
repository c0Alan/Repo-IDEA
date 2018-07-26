package com.suntek.vehicle.file.service;

import com.suntek.vehicle.file.consts.ProcessStatus;
import com.suntek.vehicle.file.consts.VehicleFileConsts;
import com.suntek.vehicle.file.entity.VehicleArchivesInformation;
import com.suntek.vehicle.file.mybatis.mapper.VehicleArchivesInformationMapper;
import com.suntek.vehicle.file.utils.VehicleFileUtils;
import com.suntek.vehicle.file.zyfw.ZyfwService;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Service
public class VehicleFileZyfwService implements IVehicleFileService {
    private static final Logger logger = Logger.getLogger(VehicleFileZyfwService.class);

    @Autowired
    private HashOperations<String, String, Object> hashOperations;

    @Autowired
    private VehicleArchivesInformationMapper vehicleArchivesInformationMapper;

    @Autowired
    private ZyfwService zyfwService;

    private ProcessStatus zyfwProcessStatus;

    /**
     * 新增记录到待入库车档信息中
     *
     * @param key
     */
    public void delFromDrkCdxx(String key) {
        Long result = hashOperations.delete(VehicleFileConsts.REDIS_HASH_DRK, key);
    }

    /**
     * 新增记录到已入库车档信息中, setnx
     *
     * @param key
     * @param value
     */
    public void addToYrkCdxx(String key, String value) {
        hashOperations.put(VehicleFileConsts.REDIS_HASH_YRK, key, value);
    }

    /**
     * 落库 MPPDB
     *
     * @param drkCdxx
     */
    public void saveCdxx(String drkCdxx) {
        String hphm = drkCdxx;
        List<Map<String, Object>> records = zyfwService.getRecords(hphm);
        if (CollectionUtils.isNotEmpty(records)) {
            for (Map record : records) {
                if (record == null) {
                    continue;
                }
                VehicleArchivesInformation information = new VehicleArchivesInformation();
                try {
                    BeanUtils.populate(information, VehicleFileUtils.keyToLowerCase(record));
//                    vehicleArchivesInformationMapper.insert(information); // 入库, 暂时注释掉
                    addToYrkCdxx(hphm, hphm);
                    delFromDrkCdxx(hphm);
                    logger.info("一车一档-已入库, key= " + hphm);
                } catch (Exception e) {
                    logger.error("一车一档-record 转 VehicleArchivesInformation 失败, " + hphm);
                }
            }
        }
    }

    /**
     * 处理资源服务接口调用逻辑
     */
    public void process() {
        logger.info("一车一档 - 资源服务接口调用.");
        if (zyfwProcessStatus == ProcessStatus.ZYFW_RUNNING) {
            return;
        }
        start();

        String drkCdxx = getOneDrkCdxx();
        logger.info("一车一档-正在入库, key= " + drkCdxx);
        if (StringUtils.isBlank(drkCdxx)) {
            zyfwProcessStatus = ProcessStatus.ZYFW_STOP;
            return;
        }

        saveCdxx(drkCdxx);

        zyfwProcessStatus = ProcessStatus.ZYFW_STOP;
    }

    public void start() {
        zyfwProcessStatus = ProcessStatus.ZYFW_RUNNING;
    }

    public void stop() {

    }

    /**
     * 获取一条待入库车档信息
     *
     * @return
     */
    public String getOneDrkCdxx() {
        Set keySet = hashOperations.keys(VehicleFileConsts.REDIS_HASH_DRK);
        if (CollectionUtils.isEmpty(keySet)) {
            return null;
        }

        return (String) keySet.iterator().next();
    }

}