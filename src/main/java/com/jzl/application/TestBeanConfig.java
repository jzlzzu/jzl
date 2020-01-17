package com.jzl.application;

import com.jzl.entity.Weather;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: jzl 注入配置文件到实体bean
 * @Description: 通过@ConditionalOnProperty 配置configuration配置是否生效
 * 通过其两个属性name以及havingValue来实现的，其中name用来从application.properties中读取某个属性值。
 * 如果该值为空，则返回false;
 * 如果值不为空，则将该值与havingValue指定的值进行比较，如果一样则返回true;否则返回false。
 * 如果返回值为false，则该configuration不生效；为true则生效
 * 注意事项: 我使用了jasypt对数据进行加密之后,在这里根据name属性获取到的值 并非是解密之后的值
 * @Date: Created in 14:38 2019/5/8
 * @Modified By:
 */
@Configuration
@ConditionalOnProperty(name = "jzl", havingValue = "ceshi")
public class TestBeanConfig {

    @Bean
    public Weather weather() {
        Weather weather = new Weather();
        System.out.println("-------------------ceshi lalla -------------------");
        return weather;
    }


}
