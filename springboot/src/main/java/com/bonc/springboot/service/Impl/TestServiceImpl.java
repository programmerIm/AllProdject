package com.bonc.springboot.service.Impl;

import com.bonc.springboot.dao.TestDao;
import com.bonc.springboot.entity.ParamBo;
import com.bonc.springboot.entity.User;
import com.bonc.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service("testService")
class TestServiceImpl implements TestService{

    @Autowired
    private TestDao testDao;

    @Override
    public User queryUser(String message) {

       User user = testDao.queryUser(message);
       return user;
    }

    @Override
    public void queryUserByUserObject(ParamBo bo) {
      User user =  testDao.queryUserByObject(bo.getUser());
      bo.setUser(user);
    }


}
