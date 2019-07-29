package com.jzl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: jzl
 * @Description: 优先读取classpath:url.properties的配置项, 找不到再去找file配置的文件配置项(按照value的顺序) 功能类似application.properties配置文件
 * 如果两个配置文件有相同key 则后面的覆盖前面的
 * @Date: Created in 17:14 2019/6/25
 * 注意 : \\在linux环境下会失效
 * @Modified By:
 */
@Configuration
@ConfigurationProperties
//@PropertySource(value = {"classpath:url.properties","file:C:\\zl\\url.properties"},ignoreResourceNotFound = true)
@PropertySource(value = {"classpath:url.properties","file:${user.dir}/url.properties"},ignoreResourceNotFound = true)
public class MyProperties {
    private String url;

    private String name;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
