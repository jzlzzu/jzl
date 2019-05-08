package com.jzl.application;

import com.jzl.entity.Weather;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 14:38 2019/5/8
 * @Modified By:
 */
@Configuration
public class TestBeanConfig {

    @Bean
    @ConditionalOnProperty(name = {"jzl"}, havingValue = "ceshi")
    public Weather weather(){
        Weather weather = new Weather();
        System.out.println("-------------------ceshi lalla -------------------");
        return weather;
    }

}
