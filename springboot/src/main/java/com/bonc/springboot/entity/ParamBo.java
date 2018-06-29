package com.bonc.springboot.entity;

import io.swagger.annotations.ApiModel;
import org.springframework.stereotype.Component;

/**
 * @author:liming
 * @Description:
 * @Date:create in 2018/6/28   19:43
 */
@Component
public class ParamBo {
    private  User user = new User();

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
