package com.springboot.mybatisplus;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.DbType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.springboot.mybatisplus.dao.EmployeeMapper;
import com.springboot.mybatisplus.entity.Employee;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author:liming
 * @Description:
 * @Date:create in 2018/7/3   15:16
 */
 public class GeneratorServiceEntity {

        @Test
        public void generateCode() {
            String packageName = "com.springboot.mybatisplus";
            boolean serviceNameStartWithI = false;//user -> UserService, 设置成true: user -> IUserService
            generateByTables(serviceNameStartWithI, packageName, "user", "role");
        }

        private void generateByTables(boolean serviceNameStartWithI, String packageName, String... tableNames) {
            //1.全局配置
            GlobalConfig config = new GlobalConfig();
            config.setActiveRecord(false)
                    .setAuthor("liming")  //作者
                    .setOutputDir("E:\\IDEA\\mavn\\mybatisplus\\src\\main\\java")  //文件存储路径
                    .setFileOverride(true)//文件覆盖
                    .setEnableCache(false)
                     .setBaseResultMap(true)
                    .setBaseColumnList(false);
            if (!serviceNameStartWithI) {
                config.setServiceName("%sService");  //是否开启I 命名前缀
            }

            //2.数据源配置
            String dbUrl = "jdbc:mysql://localhost:3306/test";
            DataSourceConfig dataSourceConfig = new DataSourceConfig();
            dataSourceConfig.setDbType(DbType.MYSQL)
                    .setUrl(dbUrl)
                    .setUsername("root")
                    .setPassword("123456")
                    .setDriverName("com.mysql.jdbc.Driver");

            //3.策略配置
            StrategyConfig strategyConfig = new StrategyConfig();
            strategyConfig
                    .setCapitalMode(true)   //全局大写命名
                    .setEntityLombokModel(false)
                    .setDbColumnUnderline(true)   //是否开启下划线
                    .setNaming(NamingStrategy.underline_to_camel)  //数据库表映射到实体类中的命名策略
                    .setTablePrefix("tbl_")    //表前缀  可数组setTablePrefix(new String[] { "tlog_", "tsys_" });
                    .setInclude("tbl_student");//修改替换成你需要的表名，多个表名传数组
                 // strategy.setExclude(new String[]{"test"}); // 需要排除生成的表

            AutoGenerator     mpg  =    new AutoGenerator();
                   mpg .setGlobalConfig(config)
                    .setDataSource(dataSourceConfig)
                    .setStrategy(strategyConfig)
                    .setPackageInfo(
                            //4.包名策略配置
                            new PackageConfig()
                                    .setParent(packageName)
                                    .setController("controller")
                                    .setEntity("entity")
                                    .setService("service")
                                    .setMapper("dao")
                    );

            // 注入自定义配置，可以在 VM 中使用 cfg.abc 【可无】
            InjectionConfig cfg = new InjectionConfig() {
                @Override
                public void initMap() {
                    Map<String, Object> map = new HashMap<String, Object>();
                    map.put("abc", this.getConfig().getGlobalConfig().getAuthor() + "-mp");
                    this.setMap(map);
                }
            };

            List<FileOutConfig> focList = new ArrayList<FileOutConfig>();
            // 调整 xml 生成目录演示
            focList.add(new FileOutConfig("/templates/mapper.xml.vm") {   //这里是固定值
                @Override
                public String outputFile(TableInfo tableInfo) {
                    return "/resources/mapper/" + tableInfo.getEntityName() + ".xml";
                }
            });
            cfg.setFileOutConfigList(focList);
            mpg.setCfg(cfg);

            // 关闭默认 xml 生成，调整生成 至 根目录
        /*    TemplateConfig tc = new TemplateConfig();
            tc.setXml(null); //不放置自定义模版 ，参数类型为模版路径/文件名  例：/templates/mapper2.xml
            mpg.setTemplate(tc);*/

            mpg.execute();
        }

        private void generateByTables(String packageName, String... tableNames) {
            generateByTables(true, packageName, tableNames);
        }
    }

