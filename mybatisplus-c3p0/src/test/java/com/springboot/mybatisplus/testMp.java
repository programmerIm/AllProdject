package com.springboot.mybatisplus;

import com.springboot.mybatisplus.dao.EmployeeMapper;
import com.springboot.mybatisplus.entity.Employee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author:liming
 * @Description:
 * @Date:create in 2018/7/3   15:16
 */
public class testMp {

    @Autowired
    private EmployeeMapper employeeMapper;
    @Test
    public void testInsert(){
        Employee  employee = new Employee();
        employee.setAge(18);
        employee.setEmail("bonc@com.cm");
        employee.setGender(1);
        employee.setLastName("lisan");
        employeeMapper.insert(employee);
    }
}
