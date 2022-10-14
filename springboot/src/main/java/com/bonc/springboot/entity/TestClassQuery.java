package com.bonc.springboot.entity;

import com.bonc.springboot.dao.TestMapper;
import com.bonc.springboot.dao.UserMapper;
import com.bonc.springboot.utils.SpringUtil;

/**
 * @author:liming
 * @Description: 测试普通类如何调用mapper
 * @Date:create in 2018/9/5   17:17
 */

public  class TestClassQuery {
    /*ApplicationContext appCtx = SpringUtil.getApplicationContext();
    public  TestDao dao = appCtx.getBean(TestDao.class);*/
    //或
    public TestMapper dao = SpringUtil.getBean(TestMapper.class);

//    public UserMapper userMapper = appCtx.getBean(UserMapper.class);

    private  User user;

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }

    public  TestClassQuery(){
        testQuery();
    }

    public  void testQuery(){
        //  user = userMapper.selectByPrimaryKey(18);
        user = dao.queryUser("1"); //通过id获取值
        System.out.println(user.toString());
    }
}
