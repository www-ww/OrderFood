package com.edu.ww.mapper;

import com.edu.ww.pojo.Address;
import com.edu.ww.pojo.Food;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressMapper {
    @Select("select * from address where userid=#{userid}")
    public List<Address> getByid(Integer userid) throws Exception;

    @Insert("insert into address(address,userid) values(#{address},#{userid})")
    public void add(Address address) throws Exception;

    @Delete("delete from address where id=#{id}")
    public void del(Integer id) throws Exception;

    @Update("update address set address=#{address} where id=#{id}")
    public void update(Address address) throws Exception;

}
