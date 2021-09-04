package com.edu.ww.service;

import com.edu.ww.pojo.Food;

import java.util.List;

public interface FoodService {

    public Food getByidSer(Integer foodid) throws Exception;

    //查询所有菜品
    public List<Food> getsSer() throws Exception;

    //插入菜品
    public void addSer(Food food) throws Exception;

    //删除菜品
    public void delSer(Integer foodid) throws Exception;

    //修改信息
    public void updateUserSer(Food food) throws Exception;

    public List<Food> findlikeSer(String foodname) throws Exception;

}
