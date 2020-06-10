package com.bonc.springboot;

import com.bonc.springboot.utils.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
/*import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;*/
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@Import(SpringUtil.class)  //如果多个使用{} 如｛DynamicDataSourceRegister.class,SpringUtil.class}
@ComponentScan(basePackages = "com.bonc.springboot")
@ServletComponentScan(basePackages = "com.bonc.springboot.controller")
@MapperScan("com.bonc.springboot.dao")
@EnableSwagger2      //启动swagger注解,覆盖范围由ComponentScan而定
public class SpringbootApplication  extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(SpringbootApplication.class);
	}

	public static void main(String[] args) {

		SpringApplication.run(SpringbootApplication.class, args);
	}
}
