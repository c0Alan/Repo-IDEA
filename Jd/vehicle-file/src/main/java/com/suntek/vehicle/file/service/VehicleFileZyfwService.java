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
        hashOperations.delete(VehicleFileConsts.REDIS_HASH_DRK, key);
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
                } catch (Exception e) {
                    logger.error("一车一档 - zyfw - record 转 VehicleArchivesInformation 失败, " + hphm);
                }
            }
            addToYrkCdxx(hphm, hphm);
            logger.info("一车一档 - zyfw - 新增入库, key= " + hphm);
        } else {
            logger.info("一车一档 - zyfw - 资源服务无数据, key= " + hphm);
        }
        if (hphm != null) {
            delFromDrkCdxx(hphm);
        }
    }

    /**
     * 处理资源服务接口调用逻辑
     */
    public void process() {
        logger.info("一车一档 - zyfw - 开始获取资源服务数据...");
        if (zyfwProcessStatus == ProcessStatus.ZYFW_RUNNING) {
            return;
        }
        start();

        String drkCdxxKey = getOneDrkCdxxKey();
//        logger.info("一车一档 - zyfw - 正在入库, key= " + drkCdxx);
        if (StringUtils.isBlank(drkCdxxKey)) {
            if (drkCdxxKey != null) {
                logger.info("一车一档 - zyfw - Redis key 为空.");
                delFromDrkCdxx(drkCdxxKey);
            } else {
                logger.info("一车一档 - zyfw - Redis 中无待入库数据.");
            }
            zyfwProcessStatus = ProcessStatus.ZYFW_STOP;
            return;
        }

        saveCdxx(drkCdxxKey);

        zyfwProcessStatus = ProcessStatus.ZYFW_STOP;
        logger.info("一车一档 - zyfw - 结束获取资源服务数据.");
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
    public String getOneDrkCdxxKey() {
        Set keySet = hashOperations.keys(VehicleFileConsts.REDIS_HASH_DRK);
        if (CollectionUtils.isEmpty(keySet)) {
            return null;
        }

        return (String) keySet.iterator().next();
    }

}