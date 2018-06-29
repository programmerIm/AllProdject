package com.bonc.springboot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@MapperScan("com.bonc.springboot.dao")
@ComponentScan(basePackages = "com.bonc.springboot")
@ServletComponentScan(basePackages = "com.bonc.springboot.controller")
@EnableSwagger2             //启动swagger注解,覆盖范围由ComponentScan而定
public class SpringbootApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringbootApplication.class, args);
	}
}
