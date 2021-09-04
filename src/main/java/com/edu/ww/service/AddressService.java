package com.edu.ww.service;

import com.edu.ww.pojo.Address;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AddressService {
    public List<Address> getByidSer(Integer userid) throws Exception;

    public void addSer(Address address) throws Exception;

    public void delSer(Integer id) throws Exception;

    public void updateSer(Address address) throws Exception;
}
