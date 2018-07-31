package com.springboot.mybatisplus.util;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;

/**
 * 自定义公共自动填充处理器
 */
public class MyMetaObjectHandler  extends MetaObjectHandler {
    /*
    插入操作自动填充
     */
    @Override
    public void insertFill(MetaObject metaObject) {
  //获取需要被填充的字段
        Object  fiLdValue = getFieldValByName("lastName",metaObject);
        if(fiLdValue==null){
            System.out.println("**********满足插入操作，自动填充********");
            setFieldValByName("name","liming",metaObject);
        }
    }

    /*
    更新操作自动填充
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        Object  fiLdValue = getFieldValByName("lastName",metaObject);
        if(fiLdValue==null){
            System.out.println("**********满足更新操作，自动填充********");
            setFieldValByName("name","liming",metaObject);
        }
    }
}
