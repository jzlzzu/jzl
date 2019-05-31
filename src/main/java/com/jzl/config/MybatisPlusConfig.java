package com.jzl.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 10:12 2019/5/31
 * @Modified By:
 */
@Configuration
@MapperScan("com.jzl.mapper")
public class MybatisPlusConfig {
    /**

     * 分页插件 : 物理分页

     */

    @Bean

    public PaginationInterceptor paginationInterceptor() {

        return new PaginationInterceptor();

    }

    /**

     * 打印 sql

     */

    @Bean

    public PerformanceInterceptor performanceInterceptor() {

        PerformanceInterceptor performanceInterceptor =new PerformanceInterceptor();

        //格式化sql语句

        Properties properties =new Properties();

        properties.setProperty("format", "faalse");

        performanceInterceptor.setProperties(properties);

        return performanceInterceptor;

    }
}
