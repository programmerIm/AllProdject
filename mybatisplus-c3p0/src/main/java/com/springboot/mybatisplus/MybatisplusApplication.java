package com.springboot.mybatisplus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import javax.sql.DataSource;


@ComponentScan(basePackages="com.springboot.mybatisplus")  //注意某个文件夹下，写到父类即可， .*会扫描不到
@MapperScan(basePackages="com.springboot.mybatisplus.dao")
@EnableAutoConfiguration
@SpringBootApplication
public class MybatisplusApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(MybatisplusApplication.class, args);
		DataSource dataSource = context.getBean(DataSource.class);
		System.out.println("数据源连接已经启动---------");
		System.out.println("数据源为-------："+dataSource.getClass());
	}
}
