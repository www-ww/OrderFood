package com.edu.ww.service.impl;

import com.edu.ww.mapper.UserMapper;
import com.edu.ww.pojo.User;
import com.edu.ww.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;


    @Override
    public User getUserByidSer(Integer userid) throws Exception {
        return userMapper.getUserByid(userid);
    }

    @Override
    public List<User> getUsersSer() throws Exception {
        return userMapper.getUsers();
    }

    @Override
    public boolean addUserSer(User user) throws Exception {
        userMapper.addUser(user);
        if(userMapper.getUserByid(user.getUserid())!=null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean delUserSer(Integer userid) throws Exception {
        userMapper.delUser(userid);
        if(userMapper.getUserByid(userid)==null)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

    @Override
    public boolean updateUserSer(User user) throws Exception {
        userMapper.updateUser(user);
            return true;
    }

    @Override
    public Integer getUserLoginSer(User user) throws Exception {
        if(userMapper.getUserLogin(user)==null)
        {
            return 0;
        }
        else
        {
            return userMapper.getUserLogin(user).getUserid();
        }
    }

    @Override
    public User getUserInSQLSer(String username) throws Exception {
        return userMapper.getUserInSQL(username);
    }

    @Override
    public void setToVipSer(Integer userid) throws Exception {
        userMapper.setToVip(userid);
    }

}
