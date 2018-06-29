package com.bonc.springboot.controller;

import com.bonc.springboot.entity.ParamBo;
import com.bonc.springboot.entity.User;
import com.bonc.springboot.service.TestService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:liming
 * @Description:
 * @Date:create in 2018/6/28   18:12
 */
@Controller
@RequestMapping("/swagger")
@Api(description ="测试swagger使用这个Controller",value = "/swagger")
public class SwaggerController {

    @Autowired
     private TestService testService;

    @Autowired
    private  ParamBo bo;
    @Autowired
    private User  user;  //页面传递参数user实体类

    private  String page;
    private Map<String,Object> map = new HashMap<>();

    @ApiOperation(value="获取用户信息",httpMethod = "GET")
    @ApiImplicitParams({
                   @ApiImplicitParam(paramType="query",name="user.name",dataType="String",value="用户的姓名"),
                    @ApiImplicitParam(paramType="query",name="user.age",dataType="String",required=true,value="用户的年龄",defaultValue="25")
              })
    @ApiResponses({
                   @ApiResponse(code=400,message="请求参数没填好"),
                   @ApiResponse(code=404,message="请求路径没有或页面跳转路径不对"),
                   @ApiResponse(code=500,message="查询失败，没有该用户")
                })
    @RequestMapping(value="/testSwagger",produces="application/json;charset=UTF-8")
    public @ResponseBody ModelAndView TestSwagger(ParamBo bo){

        System.out.println("查询参数 name:"+bo.getUser().getName()+",age:"+ bo.getUser().getAge());
        testService.queryUserByUserObject(bo);
       if (bo.getUser()==null){
           System.out.println("没有该用户");
       }else{
           System.out.println("查询出该用户信息为:"+bo.getUser().toString());
       }
       page="testSwagger";
       map.put("bo",bo);
       return new ModelAndView(page,map);
    }
}
