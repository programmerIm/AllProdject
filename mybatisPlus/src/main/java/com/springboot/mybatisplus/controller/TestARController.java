package com.springboot.mybatisplus.controller;

import com.springboot.mybatisplus.entity.Employee;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


import java.util.Map;

/**
 * @author:liming
 * @Description: 开启Active  Record
 * @Date:create in 2018/7/9   16:10
 */
@Controller
@RequestMapping(value="/testAR")
public class TestARController {

    private Map<String,Object> map ;
    private String  page;

    @RequestMapping(value="/testARInsert")
    public void testArInsert(){
        Employee  employee = new Employee();
        employee.setEmail("lisan@qq.com");
        employee.setGender(0);
        employee.setLastName("lisi");
        employee.setAge(18);
        Boolean result = employee.insert();
        System.out.println(result);
    }

    @RequestMapping(value="/testARDelete")
    public void testArDelete(){
        Employee  employee = new Employee();
        Boolean result = employee.deleteById(11);
        System.out.println("result:"+result);  //注意：这里即使没有删除成功也会返回true,
        // 默认为只要执行了sql就返回true，这是一个bug
    }

}
