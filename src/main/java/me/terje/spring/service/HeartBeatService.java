package me.terje.spring.service;

import me.terje.spring.dao.HeartBeatDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;

@Service
@ComponentScan("me.terje.spring.dao")
@ConfigurationProperties()
public class HeartBeatService {
    private static Logger logger = LoggerFactory.getLogger(HeartBeatService.class);
    private String appId;
    @Autowired
    private HeartBeatDAO heartBeatDAO;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }


    /***
     * i=0，初始化失败。
     * i=1，该app第一次初始化。
     * i=2，该app曾今初始化过。
     */
    @Transactional
    @PostConstruct
    private void init(){
        int i = heartBeatDAO.update(getAppId());
        logger.info("Initial app: "+getAppId()+", effected row is: "+i);
    }

    @Transactional
    public int beat(){
        int i = heartBeatDAO.updateBeatNum(appId);
        logger.info(""+appId+", effected row is: "+i);
        return i;
    }
}
