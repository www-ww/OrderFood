package com.edu.ww.service.impl;

import com.edu.ww.mapper.AddressMapper;
import com.edu.ww.pojo.Address;
import com.edu.ww.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {
    @Autowired
    AddressMapper mapper;

    @Override
    public List<Address> getByidSer(Integer userid) throws Exception {
        return mapper.getByid(userid);
    }

    @Override
    public void addSer(Address address) throws Exception {
        mapper.add(address);
    }

    @Override
    public void delSer(Integer id) throws Exception {
        mapper.del(id);
    }

    @Override
    public void updateSer(Address address) throws Exception {
        mapper.update(address);
    }
}
