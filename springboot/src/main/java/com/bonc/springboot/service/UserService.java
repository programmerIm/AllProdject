package com.bonc.springboot.service;

import com.bonc.springboot.entity.ParamBo;
import com.bonc.springboot.entity.User;

public interface UserService {
 User queryUser(String message);

 void queryUserByUserObject(ParamBo bo);
}
