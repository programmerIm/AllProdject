package com.bonc.springboot.service.Impl;

import com.bonc.springboot.dao.TestMapper;
import com.bonc.springboot.entity.ParamBo;
import com.bonc.springboot.entity.User;
import com.bonc.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testService")
class TestServiceImpl implements TestService{

    @Autowired
    private TestMapper testMapper;

    @Override
    public User queryUser(String message) {

       User user = testMapper.queryUser(message);
       return user;
    }

    @Override
    public void queryUserByUserObject(ParamBo bo) {
      User user =  testMapper.queryUserByObject(bo.getUser());
      bo.setUser(user);
    }


}
