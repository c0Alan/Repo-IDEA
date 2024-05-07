package com.demo.springcloud.remote;

import cn.hutool.json.JSONObject;

public interface FileService {

    String readFileFromAppHome();

    String getApplicationHome();

    String readFileApplicationHome(String filename);

    String getFilePath(String filename);

    String writeFileApplicationHome();

    public String readFileRelativePath();

    public String readFileAbsolutePath();

    public String readFileResourcePath();

    String readFileResourcePathV2();

    String readFileResourcePathV3();

    JSONObject getJsonFile(String filename);
}
