package com.test.suanfa;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@MapperScan("com.test.suanfa.dao")
@ComponentScan(basePackages = "com.test.suanfa.*")
@ServletComponentScan(basePackages = "com.test.suanfa.controller")
public class SuanfaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SuanfaApplication.class, args);
	}
}
