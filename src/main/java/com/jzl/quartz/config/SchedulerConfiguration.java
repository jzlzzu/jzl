package com.jzl.quartz.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.PropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.io.ClassPathResource;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 17:32 2019/4/23
 * @Modified By:
 */
@Configuration
@Lazy
public class SchedulerConfiguration {

    @Autowired
    private MyJobFactory myJobFactory;

    @Value("${spring.datasource.url}")
    private String str;

    @Bean(name = "schedulerFactoryBean")
    public SchedulerFactoryBean schedulerFactoryBean() throws IOException {
        //获取配置属性
        PropertiesFactoryBean propertiesFactoryBean = new PropertiesFactoryBean();
        propertiesFactoryBean.setLocation(new ClassPathResource("quartz.properties"));
        //在quartz.properties中的属性被读取并注入后再初始化对象
        propertiesFactoryBean.afterPropertiesSet();
        System.out.println(str);
        //创建SchedulerFactoryBean
        SchedulerFactoryBean factory = new SchedulerFactoryBean();
        Properties pro = propertiesFactoryBean.getObject();
//        pro.setProperty("org.quartz.dataSource.qzDS.URL","jdbc:mysql://127.0.0.1:3306/quartz?useUnicode=true&characterEncoding=utf8");
        factory.setOverwriteExistingJobs(true);
        factory.setAutoStartup(true);
        factory.setQuartzProperties(pro);
        factory.setJobFactory(myJobFactory);
        return factory;
    }

}
