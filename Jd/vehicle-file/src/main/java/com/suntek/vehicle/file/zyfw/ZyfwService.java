package com.suntek.vehicle.file.zyfw;

import com.suntek.pci.gzbidata.service.bean.ServiceInfo;
import com.suntek.pci.gzbidata.service.service.DataQuery;
import com.suntek.pci.gzbidata.service.util.CommonUtil;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 资源服务接口访问 Service
 */
@Service
public class ZyfwService {

    private DataQuery dataQuery;

    public ZyfwService() {
        ClassLoader classLoader = getClass().getClassLoader();
        URL url = classLoader.getResource("serviceConf.xml");
        ServiceInfo serviceInfo = CommonUtil.parseServiceInfo(url.getFile());
        this.dataQuery = new DataQuery(serviceInfo);
    }

    /**
     * 获取资源服务平台的车档数据
     * @param hphm 号牌号码
     * @return
     */
    public List<Map<String, Object>> getRecords(String hphm) {
//        List<Map<String, Object>> records = dataQuery.requestData(1, hphm, 30L);
        List<Map<String, Object>> records = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            Map map = new HashMap();
            map.put("XH", "XH" + i);
            map.put("HPZL", "HPZL" + i);
            records.add(map);
        }
        return records;
    }
}
