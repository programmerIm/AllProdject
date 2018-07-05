package com.springboot.mybatisplus.controller;

import com.springboot.mybatisplus.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.springboot.mybatisplus.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author:liming
 * @Description:
 * @Date:create in 2018/7/3   15:54
 */
@RestController
@RequestMapping(value="/test")
public class TestController {
    @Autowired
    private TestService testService;

    @RequestMapping(value = "/getEmployeeById")
    public void getEmployeeById(String id){
       Employee employee =   testService.queryEmployeeById(id);
        System.out.println(employee.toString());
    }

    @RequestMapping(value = "/testMenthod")
    public void getEmployeeById(){
        System.out.println("----------------进行测试热部署!--");
    }
}
