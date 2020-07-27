package me.terje.spring.dao;

import me.terje.spring.model.Order;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderDAO extends SqlSessionDaoSupport {

    @Autowired
    public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    public int save(Order order){
        return getSqlSession().insert("orm.order.insertOrder",order);
    }

    public Order getOne(int id){
        return getSqlSession().selectOne("orm.order.selectOne",id);
    }

    public int update(Order order){
        return getSqlSession().update("orm.order.update",order);
    }

    public int delete(int id){
        return getSqlSession().update("orm.order.delete",id);
    }
}
