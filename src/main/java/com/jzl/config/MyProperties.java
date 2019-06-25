package com.jzl.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 17:14 2019/6/25
 * @Modified By:
 */
@Configuration
@ConfigurationProperties
@PropertySource(value = {"classpath:url.properties","file:C:\\zl\\url.properties"})
public class MyProperties {
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
