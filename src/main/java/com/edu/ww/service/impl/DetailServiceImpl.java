package com.edu.ww.service.impl;

import com.edu.ww.mapper.DetailMapper;
import com.edu.ww.pojo.Detail;
import com.edu.ww.service.DetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DetailServiceImpl implements DetailService {
    @Autowired
    DetailMapper mapper;

    @Override
    public List<Detail> getsSer() throws Exception {
        return mapper.gets();
    }

    @Override
    public List<Detail> getByidSer(Integer orderid) throws Exception {
        return mapper.getByid(orderid);
    }

    @Override
    public void addSer(Detail detail) throws Exception {
        mapper.add(detail);
    }

    @Override
    public void delSer(Integer orderid) throws Exception {
        mapper.del(orderid);
    }

    @Override
    public void updateSer(Detail detail) throws Exception {
        updateSer(detail);
    }
}
