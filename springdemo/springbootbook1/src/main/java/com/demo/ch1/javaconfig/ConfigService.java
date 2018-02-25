package com.demo.ch1.javaconfig;

public class ConfigService {
    private ConfigDao configDao;

    public void setConfigDao(ConfigDao configDao) {
        this.configDao = configDao;
    }

    public ConfigDao getConfigDao() {
        return configDao;
    }

    public void sayHello(){
        configDao.sayHello();
    }
}
