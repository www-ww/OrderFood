package com.edu.ww.mapper;

import com.edu.ww.pojo.Complain;
import com.edu.ww.pojo.Order;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ComplainMapper {

    @Select("select * from `complain`")
    public List<Complain> gets() throws Exception;

    //插入
    @Insert("insert into `complain`(orderid,userid,`call`,text) values(#{orderid},#{userid},#{call},#{text})")
    public void add(Complain complain) throws Exception;

    //删除
    @Delete("delete from `complain` where id=#{id}")
    public void del(Integer id) throws Exception;

    //修改
    @Update("update `complain` set state=#{state} where id=#{id}")
    public void update(Complain complain) throws Exception;


    @Select("select * from `complain` where userid=#{userid} order by orderid desc")
    public List<Complain> selectByUserId(Integer userid) throws Exception;

    @Select("select * from `complain` where orderid=#{orderid}")
    public List<Complain> selectByOrderId(Integer orderid) throws Exception;

    @Select("select * from `complain` where id=#{id}")
    public Complain selectId(Integer id) throws Exception;
}
