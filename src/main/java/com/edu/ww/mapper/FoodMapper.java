package com.edu.ww.mapper;

import com.edu.ww.pojo.Food;
import com.edu.ww.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FoodMapper {
    @Select("select * from food where foodid=#{foodid}")
    public Food getByid(Integer foodid) throws Exception;

    //查询所有菜品
    @Select("select * from food")
    public List<Food> gets() throws Exception;

    //插入菜品
    @Insert("insert into food(foodname,number,price,sort,img,storeid) values(#{foodname},#{number},#{price},#{sort},#{img},#{storeid})")
    public void add(Food food) throws Exception;

    //删除菜品
    @Delete("delete from food where foodid=#{foodid}")
    public void del(Integer foodid) throws Exception;

    //修改信息
    @Update("update food set foodname=#{foodname},number=#{number},price=#{price},sort=#{sort},img=#{img},storeid=#{storeid} where foodid=#{foodid}")
    public void updateUser(Food food) throws Exception;

    @Select("select * from food where foodname like concat(concat('%',#{foodname%}),'%')")
    public List<Food> findlike(String foodname) throws Exception;

}
