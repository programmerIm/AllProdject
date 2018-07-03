package com.springboot.mybatisplus.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.springboot.mybatisplus.entity.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author:liming
 * @Description:
 * @Date:create in 2018/7/3   15:29
 */
@Mapper
public interface EmployeeMapper  extends  BaseMapper<Employee>{

    Employee queryEmployeeById(String id);
}
