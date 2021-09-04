package com.edu.ww.service.impl;

import com.edu.ww.mapper.OrderMapper;
import com.edu.ww.pojo.Order;
import com.edu.ww.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper mapper;

    @Override
    public List<Order> getOrdersSer() throws Exception {
        return mapper.getOrders();
    }

    @Override
    public void addSer(Order order) throws Exception {
        mapper.add(order);
    }

    @Override
    public void delSer(Integer orderid) throws Exception {
        mapper.del(orderid);
    }

    @Override
    public void updateUserSer(Order order) throws Exception {
        mapper.updateUser(order);
    }

    @Override
    public int selectIdSer(Order order) throws Exception {
        return mapper.selectId(order);
    }

    @Override
    public List<Order> selectByUserIdSer(Integer userid) throws Exception {
        return mapper.selectByUserId(userid);
    }

    @Override
    public Order selectByOrderIdSer(Integer orderid) throws Exception {
        return mapper.selectByOrderId(orderid);
    }

}
