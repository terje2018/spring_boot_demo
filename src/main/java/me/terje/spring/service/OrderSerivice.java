package me.terje.spring.service;

import me.terje.spring.dao.OrderDAO;
import me.terje.spring.model.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@ComponentScan("me.terje.spring.dao")
public class OrderSerivice {
    @Autowired
    private OrderDAO orderDAO;

    @Transactional
    public int save(Order order){
        return orderDAO.save(order);
    }

    public Order get(int id){
        return orderDAO.getOne(id);
    }

    @Transactional
    public int update(Order order){
        return orderDAO.update(order);
    }

    @Transactional
    public int delete(int id){
        return orderDAO.delete(id);
    }

}
