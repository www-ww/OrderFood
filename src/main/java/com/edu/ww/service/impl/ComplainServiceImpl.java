package com.edu.ww.service.impl;

import com.edu.ww.mapper.ComplainMapper;
import com.edu.ww.pojo.Complain;
import com.edu.ww.service.ComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplainServiceImpl implements ComplainService {
    @Autowired
    ComplainMapper mapper;


    @Override
    public List<Complain> getsSer() throws Exception {
        return mapper.gets();
    }

    @Override
    public void addSer(Complain complain) throws Exception {
        mapper.add(complain);
    }

    @Override
    public void delSer(Integer id) throws Exception {
        mapper.del(id);
    }

    @Override
    public void updateSer(Complain complain) throws Exception {
mapper.update(complain);
    }

    @Override
    public List<Complain> selectByUserIdSer(Integer userid) throws Exception {
        return mapper.selectByUserId(userid);
    }

    @Override
    public List<Complain> selectByOrderIdSer(Integer orderid) throws Exception {
        return mapper.selectByOrderId(orderid);
    }

    @Override
    public Complain selectIdSer(Integer id) throws Exception {
        return mapper.selectId(id);
    }
}
