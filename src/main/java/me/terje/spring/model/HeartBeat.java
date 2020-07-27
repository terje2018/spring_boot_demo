package me.terje.spring.model;

import java.io.Serializable;
import java.util.Date;

public class HeartBeat implements Serializable{
    private String appId;
    private Double beatNum;
    private Date lastBeatTime;
    private Date appStartTime;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public Double getBeatNum() {
        return beatNum;
    }

    public void setBeatNum(Double beatNum) {
        this.beatNum = beatNum;
    }

    public Date getLastBeatTime() {
        return lastBeatTime;
    }

    public void setLastBeatTime(Date lastBeatTime) {
        this.lastBeatTime = lastBeatTime;
    }

    public Date getAppStartTime() {
        return appStartTime;
    }

    public void setAppStartTime(Date appStartTime) {
        this.appStartTime = appStartTime;
    }
}
