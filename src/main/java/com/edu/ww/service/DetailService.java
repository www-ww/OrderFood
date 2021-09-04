package com.edu.ww.service;

import com.edu.ww.pojo.Detail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface DetailService {

    public List<Detail> getsSer() throws Exception;

    public List<Detail> getByidSer(Integer orderid) throws Exception;

    public void addSer(Detail detail) throws Exception;

    public void delSer(Integer orderid) throws Exception;

    public void updateSer(Detail detail) throws Exception;

}
