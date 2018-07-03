package com.springboot.mybatisplus.service;

import com.baomidou.mybatisplus.service.IService;
import com.springboot.mybatisplus.entity.Employee;
import org.springframework.stereotype.Service;

/**
 * @author:liming
 * @Description:
 * @Date:create in 2018/7/3   15:47
 */

public interface TestService extends IService<Employee> {
   Employee queryEmployeeById(String id);
}
