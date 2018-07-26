package com.suntek.vehicle.file.utils;

import com.suntek.vehicle.file.entity.VehicleArchivesInformation;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 车档工具类
 */
public class VehicleFileUtils {

    /**
     * 生成 Redis 记录的 key
     * 车牌号-车牌颜色-车辆类型
     *
     * @param map
     * @return
     */
    public static String getRedisKey(Map map) {
        String key = map.get("HPHM") + "-" + map.get("PLATE_COLOR") + "-" + map.get("VEHICLE_TYPE");
        return key;
    }

    public static String getRedisKey(VehicleArchivesInformation information) {
        String key = information.getHphm() + "-" + information.getHpzl();
        return key;
    }

    /**
     * Map 的键转小写, 方便 Map 转 Bean
     * @param map
     * @return
     */
    public static Map<String, Object> keyToLowerCase(Map<String, Object> map){
        if(map == null){
            return null;
        }

        Map<String, Object> newMap = new HashMap<>();

        for(Map.Entry<String, Object> entry : map.entrySet()){
            String key = StringUtils.lowerCase(entry.getKey());
            newMap.put(key, entry.getValue());
        }

        return newMap;
    }
}
