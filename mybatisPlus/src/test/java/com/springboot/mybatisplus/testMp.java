package com.springboot.mybatisplus;

import com.baomidou.mybatisplus.plugins.Page;
import com.springboot.mybatisplus.dao.EmployeeMapper;
import com.springboot.mybatisplus.entity.Employee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @author:liming
 * @Description:
 * @Date:create in 2018/7/9   19:08
 */
public class TestMp {

    @Autowired
    private EmployeeMapper  employeeMapper;

    @Test
    public void testInterator(){
        List<Employee> list =  employeeMapper.selectPage(new Page<Employee>(1,1),null);
        System.out.println(list);
    }
}
