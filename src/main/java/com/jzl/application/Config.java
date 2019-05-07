package com.jzl.application;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 10:27 2019/5/7
 * @Modified By:
 */
@Configuration
@ConfigurationProperties
@Data
public class Config {
    private String jzl;
}
