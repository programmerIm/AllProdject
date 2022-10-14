package com.bonc.springboot;

import com.bonc.springboot.utils.SpringUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication
@Import(SpringUtil.class)  //如果多个使用{} 如｛DynamicDataSourceRegister.class,SpringUtil.class}
@MapperScan("com.bonc.springboot.dao")
@EnableSwagger2      //启动swagger注解,覆盖范围由ComponentScan而定
public class SpringbootApplication{

	public static void main(String[] args) {
		SpringApplication.run(SpringbootApplication.class, args);
	}
}
