package com.edu.ww.mapper;

import com.edu.ww.pojo.Address;
import com.edu.ww.pojo.Detail;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailMapper {
    @Select("select * from detail")
    public List<Detail> gets() throws Exception;

    @Select("select * from detail where orderid=#{orderid}")
    public List<Detail> getByid(Integer orderid) throws Exception;

    @Insert("insert into detail(orderid,foodid,number) values(#{orderid},#{foodid},#{number})")
    public void add(Detail detail) throws Exception;

    @Delete("delete from detail where orderid=#{orderid}")
    public void del(Integer orderid) throws Exception;

    @Update("update detail set orderid=#{orderid},foodid=#{foodid},number=#{number} where detailid=#{detailid}")
    public void update(Detail detail) throws Exception;
}
