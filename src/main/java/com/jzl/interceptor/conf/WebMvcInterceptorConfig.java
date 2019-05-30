package com.jzl.interceptor.conf;

import com.jzl.interceptor.Jzl1Interceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 15:37 2019/5/30
 * @Modified By:
 */
@Configuration
public class WebMvcInterceptorConfig extends WebMvcConfigurationSupport {

    @Autowired
    Jzl1Interceptor jzl1Interceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(jzl1Interceptor).addPathPatterns("/**");
    }
}
