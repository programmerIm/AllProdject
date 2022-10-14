package com.bonc.springboot.dao;

import com.bonc.springboot.entity.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author:liming
 * @Description:
 * @Date:create in 15:12 2018/5/30
 */
@Mapper
public interface UserMapper {

      User queryUser(String message);

     User  queryUserByObject(User user);
}
