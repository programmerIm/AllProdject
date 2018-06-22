package com.bonc.springboot.autoConfigure;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author:liming
 * @Description:
 * @Date:create in 2018/6/22   10:30
 */
@Configuration
@EnableConfigurationProperties(TestProperties.class)
public class TestPropertiesClass {
    @Autowired
    private static TestProperties testProperties;


}
