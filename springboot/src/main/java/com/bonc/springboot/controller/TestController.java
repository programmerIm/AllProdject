package com.bonc.springboot.controller;


import com.bonc.springboot.autoConfigure.TestProperties;
import com.bonc.springboot.entity.ParamBo;
import com.bonc.springboot.entity.TestClassQuery;
import com.bonc.springboot.entity.User;
import com.bonc.springboot.utils.SpringUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.aspectj.weaver.ast.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.web.bind.annotation.*;
import com.bonc.springboot.service.TestService;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.util.HashMap;
import  java.util.Map;

@RestController  //一般有jsp交互就是用该注解
@RequestMapping(value ="/springBootTest")
@Api(description = "基础测试Controller",value = "/springBootTest")
public class TestController {
    private static Logger logger = LoggerFactory.getLogger(TestController.class);

    @Autowired
    private  TestService  testService;
    @Autowired
    private TestProperties testProperties; //读取配置文件信息实体类

    @Autowired
    private Environment env;  //环境对象

    private Map<String,Object> map = new HashMap<>();

    private String page ;

    @ApiOperation(value="普通参数请求")
    @RequestMapping(value="/test1", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    public @ResponseBody User test1(@RequestParam(name="id",required = true ) String id){
        System.out.println("参数为"+id);
       return  testService.queryUser(id); //通过id查询
    }

    /*
     读取配置文件中参数的方法1
     */
    @ApiOperation("读取配置文件请求")
    @RequestMapping(value = "/getProperties", method = RequestMethod.GET)
    @ResponseBody
    public  ModelAndView getProperties(){
        System.out.println(testProperties.getAge());
        System.out.println(testProperties.getName());
        page= "index";
        return  new ModelAndView(page,map);
    }

     //通过  Environment 对象获取配置文件信息
    @ApiOperation("Environment 获取配置文件信息")
    @RequestMapping(value = "/getProperties2", method = RequestMethod.GET)
    public  void getProperties2(){
        System.out.println(env.getProperty("spring.test.name"));
        System.out.println(env.getProperty("spring.test.age"));
    }

    //通过实体对象封装请求参数,bo 中 有User对象，声明时New 一个出来，请求中不带bo
    //url= http://127.0.0.1:8080/springBootTest/getParamByObject?user.age=18
    @ApiOperation("实体类封装参数请求")
    @RequestMapping(value="/getParamByObject",method = RequestMethod.GET)
   public void getParamByObject(ParamBo bo){
        logger.info("通过实体对象获取到的参数为User.age:"+bo.getUser().getAge());
   }


   //普通类进行构造的时候，可以调用dao 对象
   @RequestMapping(value="/testClassQuery")
   public  void  testClassQuery(){
     TestClassQuery testClassQuery =new TestClassQuery();
   }


   @RequestMapping(value = "/testPath")
    public  void testPath(){
     String path = ClassUtils.getDefaultClassLoader().getResource("").getPath();
       System.out.println(path);
       File file = new File(path+"/hello.txt");
   }
}
