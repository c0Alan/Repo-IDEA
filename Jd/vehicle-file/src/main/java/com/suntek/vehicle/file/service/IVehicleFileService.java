package com.suntek.vehicle.file.service;

public interface IVehicleFileService {
    /**
     * 开始执行
     */
    public void process();

    /**
     * 启动开关
     */
    public void start();

    /**
     * 关闭开关
     */
    public void stop();
}
