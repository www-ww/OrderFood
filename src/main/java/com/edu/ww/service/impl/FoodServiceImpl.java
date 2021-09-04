package com.edu.ww.service.impl;

import com.edu.ww.mapper.FoodMapper;
import com.edu.ww.pojo.Food;
import com.edu.ww.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    FoodMapper mapper;

    @Override
    public Food getByidSer(Integer foodid) throws Exception {
        return mapper.getByid(foodid);
    }

    @Override
    public List<Food> getsSer() throws Exception {
        return mapper.gets();
    }

    @Override
    public void addSer(Food food) throws Exception {
        mapper.add(food);
    }

    @Override
    public void delSer(Integer foodid) throws Exception {
        mapper.del(foodid);
    }

    @Override
    public void updateUserSer(Food food) throws Exception {
        mapper.updateUser(food);
    }

    @Override
    public List<Food> findlikeSer(String foodname) throws Exception {
        return mapper.findlike(foodname);
    }
}
