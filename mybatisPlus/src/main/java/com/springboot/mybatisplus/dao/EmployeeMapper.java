package com.springboot.mybatisplus.dao;

import com.springboot.mybatisplus.entity.Employee;
import org.springframework.stereotype.Repository;

/**
 * @author:liming
 * @Description:
 * @Date:create in 2018/7/3   15:29
 */
@Repository
public interface EmployeeMapper {

    Employee queryEmployeeById(String id);
}
