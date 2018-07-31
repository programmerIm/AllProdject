package com.springboot.mybatisplus.entity;

import com.baomidou.mybatisplus.annotations.KeySequence;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableLogic;
import com.baomidou.mybatisplus.enums.IdType;
import com.baomidou.mybatisplus.annotations.TableName;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liming
 * @since 2018-07-11
 */
@KeySequence(value = "tb_st",clazz = Integer.class)  //写表的序列名称
@TableName("tbl_student")
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    private String className;
  //@TableId(value = "id", type = IdType.INPUT)
    private Integer id;
    private String studentName;
    private Integer age;

    @TableLogic   //逻辑删除标识
    private Integer loginFlag;


    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getLoginFlag() {
        return loginFlag;
    }

    public void setLoginFlag(Integer loginFlag) {
        this.loginFlag = loginFlag;
    }

    @Override
    public String toString() {
        return "Student{" +
        ", className=" + className +
        ", id=" + id +
        ", studentName=" + studentName +
        ", age=" + age +
        ", loginFlag=" + loginFlag +
        "}";
    }
}
