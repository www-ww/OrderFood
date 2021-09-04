package com.edu.ww.service;

import com.edu.ww.pojo.User;

import java.util.List;
/*
用户service层
 */
public interface UserService {

    public User getUserByidSer(Integer userid) throws Exception;

    public List<User> getUsersSer() throws Exception;

    public boolean addUserSer(User user) throws Exception;

    public boolean delUserSer(Integer userid) throws Exception;

    public boolean updateUserSer(User user) throws Exception;

    public Integer getUserLoginSer(User user)throws Exception;

    public User getUserInSQLSer(String username)throws Exception;

    public void setToVipSer(Integer userid) throws Exception;
}
