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

    @RequestMapping(value = "/testInsert")
    public void testInsert(){
        Employee  employee = new Employee();
        employee.setAge(18);
        employee.setEmail("bonc@com.cm");
       /* employee.setGender(1);
        employee.setLastName("lisan");*/
        employee.setOrder("111"); //自动被过滤
       //  testService.insert(employee);
     Boolean  falg =   testService.insertAllColumn(employee);
        System.out.println(falg);
         //返回新增主键
        Integer id = employee.getId();
        System.out.println("新增实体类主键Key为："+id);
    }


    /**
     * 通用更新
     */
    @RequestMapping(value="/testUpdate")
    public void testUpdate(){
     Employee employee = new Employee();
     employee.setEmail("xiaoze@qq.com");
     employee.setId(12);
     testService.updateById(employee);
    }

    @RequestMapping(value="/testSelect")
    public void testSelect(){
     Employee employee = testService.selectById(8);
        System.out.println(employee.toString());
    }

    @RequestMapping(value="/testDelete")
    public void testDelete(){
        Boolean reslut =  testService.deleteById(8);
        System.out.println(reslut);
    }

}
