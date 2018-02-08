package com.model.mybatis;

public class TSysPermission {
    private Integer nId;

    private Short nValid;

    private String cName;

    private Integer nParentId;

    private String cParentIds;

    private String cPermission;

    private String cResourceType;

    private String cUrl;

    public Integer getnId() {
        return nId;
    }

    public void setnId(Integer nId) {
        this.nId = nId;
    }

    public Short getnValid() {
        return nValid;
    }

    public void setnValid(Short nValid) {
        this.nValid = nValid;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public Integer getnParentId() {
        return nParentId;
    }

    public void setnParentId(Integer nParentId) {
        this.nParentId = nParentId;
    }

    public String getcParentIds() {
        return cParentIds;
    }

    public void setcParentIds(String cParentIds) {
        this.cParentIds = cParentIds == null ? null : cParentIds.trim();
    }

    public String getcPermission() {
        return cPermission;
    }

    public void setcPermission(String cPermission) {
        this.cPermission = cPermission == null ? null : cPermission.trim();
    }

    public String getcResourceType() {
        return cResourceType;
    }

    public void setcResourceType(String cResourceType) {
        this.cResourceType = cResourceType == null ? null : cResourceType.trim();
    }

    public String getcUrl() {
        return cUrl;
    }

    public void setcUrl(String cUrl) {
        this.cUrl = cUrl == null ? null : cUrl.trim();
    }
}