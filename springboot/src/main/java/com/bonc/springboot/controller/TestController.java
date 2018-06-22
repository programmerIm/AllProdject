package com.bonc.springboot.controller;


import com.bonc.springboot.autoConfigure.TestProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.bonc.springboot.service.TestService;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import  java.util.Map;

@RestController  //一般有jsp交互就是用该注解
@RequestMapping(value ="/springBootTest")
public class TestController {

    @Autowired
    private  TestService  testService;
    @Autowired
    private TestProperties testProperties; //读取配置文件信息实体类

    @Autowired
    private Environment env;

    private Map<String,Object> map = new HashMap<>();

    private String page ;

    @RequestMapping(value="/test1", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public void test1(@RequestParam(name="mes",required = true ) String mes){
        System.out.println("参数为"+mes);
        testService.queryUser(mes);
    }

    /*
     读取配置文件中参数的方法1
     */
    @RequestMapping(value = "/getProperties", method = RequestMethod.GET)
    @ResponseBody
    public  ModelAndView getProperties(){
        System.out.println(testProperties.getAge());
        System.out.println(testProperties.getName());
        page= "index";
        return  new ModelAndView(page,map);
    }

     //通过  Environment 对象获取配置文件信息
    @RequestMapping(value = "/getProperties2", method = RequestMethod.GET)
    public  void getProperties2(){
        System.out.println(env.getProperty("spring.test.name"));
        System.out.println(env.getProperty("spring.test.age"));
    }

}
