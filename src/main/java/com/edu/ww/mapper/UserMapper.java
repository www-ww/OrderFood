package com.edu.ww.mapper;

import com.edu.ww.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
用户持久层
 */
@Repository
public interface UserMapper {

    /*
    根据id查询用户
     */
    @Select("select * from user where userid=#{userid}")
    public User getUserByid(Integer userid) throws Exception;

    //查询所有用户
    @Select("select * from user")
    public List<User> getUsers() throws Exception;

    //插入用户
    @Insert("insert into user(username,password,phone,email,gender) values(#{username},#{password},#{phone},#{email},#{gender})")
    public void addUser(User user) throws Exception;

    //删除用户
    @Delete("delete from user where userid=#{userid}")
    public void delUser(Integer userid) throws Exception;

    //修改用户信息
    @Update("update user set password=#{password},phone=#{phone},email=#{email},gender=#{gender} where userid=#{userid}")
    public void updateUser(User user) throws Exception;

    //根据用户名和密码查询
    @Select("select * from user where username=#{username} and password=#{password}")
    public User getUserLogin(User user)throws Exception;

    //查询用户名是否已经存在
    @Select("select * from user where username=#{username}")
    public User getUserInSQL(String username)throws Exception;

    //修改为vip客户
    @Update("update user set vip='yes' where userid=#{userid}")
    public void setToVip(Integer userid) throws Exception;

}
