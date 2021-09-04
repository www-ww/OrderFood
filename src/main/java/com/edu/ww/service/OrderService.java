package com.edu.ww.service;

import com.edu.ww.pojo.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface OrderService {
    public List<Order> getOrdersSer() throws Exception;

    //插入菜品
    public void addSer(Order order) throws Exception;

    //删除菜品
    public void delSer(Integer orderid) throws Exception;

    //修改信息
    public void updateUserSer(Order order) throws Exception;

    //查询id
    public int selectIdSer(Order order) throws Exception;

    //查询用户订单
    public List<Order> selectByUserIdSer(Integer userid) throws Exception;

    //根据id查询订单
    public Order selectByOrderIdSer(Integer orderid) throws Exception;


}
