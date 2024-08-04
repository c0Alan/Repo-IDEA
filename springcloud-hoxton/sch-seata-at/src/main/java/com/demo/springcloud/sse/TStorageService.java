package com.demo.springcloud.sse;

import com.baomidou.mybatisplus.extension.service.IService;
import com.demo.springcloud.entity.TStorage;

/**
 * <p>
 * 仓库表 服务类
 * </p>
 *
 * @author liuxl
 * @since 2024-05-14
 */
public interface TStorageService extends IService<TStorage> {

    void deduct(String commodityCode, int orderCount);
}
