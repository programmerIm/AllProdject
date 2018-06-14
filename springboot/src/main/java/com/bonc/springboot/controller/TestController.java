package com.bonc.springboot.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.bonc.springboot.service.TestService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller //一般有jsp交互就是用该注解
@RequestMapping(value ="/springBootTest")
public class TestController {

    @Autowired
    private  TestService  testService;

    @RequestMapping(value="/test1", method = RequestMethod.GET,produces="application/json;charset=UTF-8")
    @ResponseBody
    public void test1(@RequestParam(name="mes",required = true ) String mes){
        System.out.println("参数为"+mes);
        testService.queryUser(mes);
    }
}
