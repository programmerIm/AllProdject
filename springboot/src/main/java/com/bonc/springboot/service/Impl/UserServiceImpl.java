package com.bonc.springboot.service.Impl;

import com.bonc.springboot.dao.UserMapper;
import com.bonc.springboot.entity.ParamBo;
import com.bonc.springboot.entity.User;
import com.bonc.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User queryUser(String message) {

       User user = userMapper.queryUser(message);
       return user;
    }

    @Override
    public void queryUserByUserObject(ParamBo bo) {
      User user =  userMapper.queryUserByObject(bo.getUser());
      bo.setUser(user);
    }


}
