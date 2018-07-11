package com.springboot.mybatisplus.util;


import com.baomidou.mybatisplus.entity.TableInfo;
import com.baomidou.mybatisplus.enums.SqlMethod;
import com.baomidou.mybatisplus.mapper.AutoSqlInjector;
import org.apache.ibatis.builder.MapperBuilderAssistant;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.session.Configuration;

/**
 * 自定义全局操作
 */
public class MySqlInjector  extends AutoSqlInjector{
    /**
     * 自定义方法，注入点（子类需重写该方法）
     */
    public void inject(Configuration configuration, MapperBuilderAssistant builderAssistant, Class<?> mapperClass,
                       Class<?> modelClass, TableInfo table) {
        //将EmployeeMapper中的自定义方法，处理成MappedStatement对象，加入到Configuration中

        //定义需要注入的sql语句
       String  sql = "select * from  " + table.getTableName() +" where "+table.getKeyColumn() +" = " +"#{"+table.getKeyProperty()+"}" ;

       //注入的方法名，一定要与Mapper接口中定义的一致
        String  sqlMethod = "queryEmployeeById";

        //构造sqlSource对象
        SqlSource sqlSource  = languageDriver.createSqlSource(configuration,sql,modelClass);

        this.addSelectMappedStatement(mapperClass,sqlMethod,sqlSource,modelClass,table);
    }
}
