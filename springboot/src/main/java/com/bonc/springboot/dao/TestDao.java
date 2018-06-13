package com.bonc.springboot.dao;

import com.bonc.springboot.entity.User;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/**
 * @author:liming
 * @Description:
 * @Date:create in 15:12 2018/5/30
 */
@Repository
public interface TestDao {

     public User queryUser(String message);
}
