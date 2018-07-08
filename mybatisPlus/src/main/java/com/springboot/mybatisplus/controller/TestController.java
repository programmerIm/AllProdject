package com.springboot.mybatisplus.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.springboot.mybatisplus.dao.EmployeeMapper;
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

    @Autowired
    private EmployeeMapper  employeeMapper;


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
        //  Integer result = employeeMapper.deleteById(8);  //直接用Mapper去执行，查看运行原理
        System.out.println(reslut);
    }


    /**
     * 调价构造器  - 查询分页
     * 条件：查询一也一个，年龄18到25，名字中带有  “lisan”的
     */
    @RequestMapping(value="/testSelectPage")
   public void testSelectPage(){

     /*   Page<Employee>  employees =  testService.selectPage(new Page<Employee>(1,1), new EntityWrapper<Employee>().between("age",18,25).like("last_name","lisan"));
        System.out.println(employees);*/    //使用sever返回的是page对象
    List<Employee>   employees  =    employeeMapper.selectPage(new Page<Employee>(1,1), new EntityWrapper<Employee>().between("age",18,25).like("last_name","lisan"));
        System.out.println(employees);   //使用mapper返回的是List
    }

    @RequestMapping(value="/testUpdatePage")
    public void testUpdatePage(){
        Employee employee = new Employee();
        employee.setAge(50);
        employee.setLastName("赵四");
        employeeMapper.update(employee,new EntityWrapper<Employee>().eq("age",18).eq("gender",0));

    }

    @RequestMapping(value="/testDeletePage")
    public void testDeletePage(){

        employeeMapper.delete(new EntityWrapper<Employee>().eq("age",18));

    }


}
