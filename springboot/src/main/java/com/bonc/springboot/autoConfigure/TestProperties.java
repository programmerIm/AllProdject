package com.bonc.springboot.autoConfigure;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author:liming
 * @Description: 读取配置文件信息
 * @Date:create in 2018/6/22   10:00
 */
@ConfigurationProperties(prefix = "spring.test")
@Component  //使用@Component是让该类能够在其他地方被依赖使用，即使用@Autowired注释来创建实例。
public class TestProperties {
    private String name;
    private String age;
    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
