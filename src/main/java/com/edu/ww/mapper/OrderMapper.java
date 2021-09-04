package com.edu.ww.mapper;

import com.edu.ww.pojo.Food;
import com.edu.ww.pojo.Order;
import com.edu.ww.pojo.User;
import com.github.pagehelper.ISelect;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Repository
public interface OrderMapper {
    @Select("select * from `order`")
    public List<Order> getOrders() throws Exception;

    //插入
    @Insert("insert into `order`(userid,state,allprice,`to`,time) values(#{userid},#{state},#{allprice},#{to},#{time})")
    public void add(Order order) throws Exception;

    //删除
    @Delete("delete from `order` where orderid=#{orderid}")
    public void del(Integer orderid) throws Exception;

    //修改
    @Update("update `order` set state=#{state},allprice=#{allprice},`to`=#{to},time=#{time} where orderid=#{orderid}")
    public void updateUser(Order order) throws Exception;

    @Select("select orderid from `order` where userid=#{userid} and state=#{state} and allprice=#{allprice} and `to`=#{to} and time=#{time}")
    public int selectId(Order order) throws Exception;

    @Select("select * from `order` where userid=#{userid} order by orderid desc")
    public List<Order> selectByUserId(Integer userid) throws Exception;

    @Select("select * from `order` where orderid=#{orderid}")
    public Order selectByOrderId(Integer orderid) throws Exception;



}
















