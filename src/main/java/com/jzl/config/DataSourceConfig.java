package com.jzl.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.sql.DataSource;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 9:28 2019/4/13
 * @Modified By:
 */
@Configuration
@MapperScan(basePackages = {"com.jzl.mapper"},sqlSessionFactoryRef = "")
public class DataSourceConfig {

    @Bean(name = "jzlDataSource")
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource.first")
    public DataSource getDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "jzlSlaveDataSource")
    @ConfigurationProperties(prefix = "spring.datasource.second")
    public DataSource getSlaveDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Bean
    public SqlSessionFactory jzlSqlSessionFactory(@Qualifier("jzlDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate jzlSqlSessionTemplate(@Qualifier("jzlSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        return template;
    }

    /**
     * 从
     * @param dataSource
     * @return
     * @throws Exception
     */
    @Bean
    public SqlSessionFactory jzlSlaveSqlSessionFactory(@Qualifier("jzlSlaveDataSource") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        return sqlSessionFactoryBean.getObject();
    }

    @Bean
    public SqlSessionTemplate jzlSlaveSqlSessionTemplate(@Qualifier("jzlSlaveSqlSessionFactory") SqlSessionFactory sqlSessionFactory){
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory);
        return template;
    }

}
