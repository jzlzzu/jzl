package com.jzl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: jzl
 * @Description: 优先读取classpath:url.properties的配置项, 找不到再去找file配置的文件
 * @Date: Created in 17:14 2019/6/25
 * @Modified By:
 */
@Configuration
@ConfigurationProperties
@PropertySource(value = {"classpath:url.properties","file:C:\\zl\\url.properties"},ignoreResourceNotFound = true)
public class MyProperties {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
