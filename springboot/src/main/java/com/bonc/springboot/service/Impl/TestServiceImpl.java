package com.bonc.springboot.service.Impl;

import com.bonc.springboot.dao.TestDao;
import com.bonc.springboot.entity.User;
import com.bonc.springboot.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("testService")
class TestServiceImpl implements TestService{

    @Autowired
    private TestDao testDao;

    @Override
    public void queryUser(String message) {
        User user = testDao.queryUser(message);
        System.out.println(user.toString());
    }
}
