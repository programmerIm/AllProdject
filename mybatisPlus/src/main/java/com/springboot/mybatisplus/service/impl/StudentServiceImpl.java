package com.springboot.mybatisplus.service.impl;

import com.springboot.mybatisplus.dao.StudentMapper;
import com.springboot.mybatisplus.entity.Student;
import com.springboot.mybatisplus.service.StudentService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liming
 * @since 2018-07-11
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
