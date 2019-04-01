package com.multiple.datasource.dao1.entity;

import java.util.Date;

public class Instanceconfig {
    private Integer id;

    private Integer instanceid;

    private String configappid;

    private String configclustername;

    private String confignamespacename;

    private String releasekey;

    private Date releasedeliverytime;

    private Date datachangeCreatedtime;

    private Date datachangeLasttime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getInstanceid() {
        return instanceid;
    }

    public void setInstanceid(Integer instanceid) {
        this.instanceid = instanceid;
    }

    public String getConfigappid() {
        return configappid;
    }

    public void setConfigappid(String configappid) {
        this.configappid = configappid == null ? null : configappid.trim();
    }

    public String getConfigclustername() {
        return configclustername;
    }

    public void setConfigclustername(String configclustername) {
        this.configclustername = configclustername == null ? null : configclustername.trim();
    }

    public String getConfignamespacename() {
        return confignamespacename;
    }

    public void setConfignamespacename(String confignamespacename) {
        this.confignamespacename = confignamespacename == null ? null : confignamespacename.trim();
    }

    public String getReleasekey() {
        return releasekey;
    }

    public void setReleasekey(String releasekey) {
        this.releasekey = releasekey == null ? null : releasekey.trim();
    }

    public Date getReleasedeliverytime() {
        return releasedeliverytime;
    }

    public void setReleasedeliverytime(Date releasedeliverytime) {
        this.releasedeliverytime = releasedeliverytime;
    }

    public Date getDatachangeCreatedtime() {
        return datachangeCreatedtime;
    }

    public void setDatachangeCreatedtime(Date datachangeCreatedtime) {
        this.datachangeCreatedtime = datachangeCreatedtime;
    }

    public Date getDatachangeLasttime() {
        return datachangeLasttime;
    }

    public void setDatachangeLasttime(Date datachangeLasttime) {
        this.datachangeLasttime = datachangeLasttime;
    }
}