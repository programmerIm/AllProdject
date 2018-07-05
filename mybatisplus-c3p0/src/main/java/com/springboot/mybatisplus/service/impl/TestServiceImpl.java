package com.springboot.mybatisplus.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.springboot.mybatisplus.entity.Employee;
import com.springboot.mybatisplus.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.mybatisplus.dao.EmployeeMapper;

/**
 * @author:liming
 * @Description:
 * @Date:create in 2018/7/3   15:48
 */
@Service("TestService")
public class TestServiceImpl extends ServiceImpl<EmployeeMapper,Employee> implements TestService {
    @Autowired
    private EmployeeMapper testDao;

    public Employee queryEmployeeById(String id){
       return   testDao.queryEmployeeById(id);
    }

}
