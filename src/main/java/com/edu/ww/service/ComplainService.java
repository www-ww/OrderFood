package com.edu.ww.service;

import com.edu.ww.pojo.Complain;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ComplainService {
    public List<Complain> getsSer() throws Exception;

    //插入
    public void addSer(Complain complain) throws Exception;

    //删除
    public void delSer(Integer id) throws Exception;

    //修改
    public void updateSer(Complain complain) throws Exception;


    public List<Complain> selectByUserIdSer(Integer userid) throws Exception;

    public List<Complain> selectByOrderIdSer(Integer orderid) throws Exception;

    public Complain selectIdSer(Integer id) throws Exception;

}
