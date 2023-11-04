package com.jin.config;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MyBatisPlusGenerator {
    public static void main(String[] args) {

        AutoGenerator autoGenerator = new AutoGenerator();

        //1. 全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        String  prjPath = System.getProperty("user.dir");
        globalConfig.setOutputDir(prjPath+"/src/main/java");
        globalConfig.setFileOverride(true);//是否覆盖
        globalConfig.setOpen(false);//是否打开文件
        globalConfig.setAuthor("大力pig");
        globalConfig.setSwagger2(false);
        globalConfig.setServiceName("%sService");
        globalConfig.setEntityName("%sEntity");
        globalConfig.setIdType(IdType.ID_WORKER);
        globalConfig.setDateType(DateType.ONLY_DATE);
        autoGenerator.setGlobalConfig(globalConfig);


        //2.设置数据源
        DataSourceConfig dataSourceConfig = new DataSourceConfig();
        dataSourceConfig.setSchemaName("test");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/test");
        dataSourceConfig.setDriverName("com.mysql.jdbc.Driver");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("123456");
        dataSourceConfig.setDbType(DbType.MYSQL);
        autoGenerator.setDataSource(dataSourceConfig);


        //3.包的配置
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.jin");
        packageConfig.setEntity("entity");
        packageConfig.setMapper("mapper");
        packageConfig.setService("service");
        autoGenerator.setPackageInfo(packageConfig);

        //4.策略配置
        StrategyConfig strategyConfig = new StrategyConfig();
        strategyConfig.setInclude("user"); //想要生成的表名
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);
        strategyConfig.setEntityLombokModel(true);//自动lombok
        strategyConfig.setControllerMappingHyphenStyle(true);//支持连字符串样式
        autoGenerator.setStrategy(strategyConfig);
        autoGenerator.execute();



    }
}
