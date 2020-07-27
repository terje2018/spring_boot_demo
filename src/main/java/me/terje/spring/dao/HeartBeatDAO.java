package me.terje.spring.dao;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class HeartBeatDAO extends SqlSessionDaoSupport {

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public int update(String appId){
        return getSqlSession().update("orm.heartbeat.initial",appId);
    }

    public int updateBeatNum(String appId){
        int beatNum = getSqlSession().selectOne("orm.heartbeat.select_beat_num",appId);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("appId",appId);
        map.put("num",beatNum);
        return getSqlSession().update("orm.heartbeat.beat",map);
    }
}
