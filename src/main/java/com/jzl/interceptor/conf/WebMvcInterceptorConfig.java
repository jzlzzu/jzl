package com.jzl.interceptor.conf;

import com.jzl.interceptor.Jzl1Interceptor;
import com.jzl.interceptor.Jzl2Interceptor;
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

    @Autowired
    Jzl2Interceptor jzl2Interceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        //设置拦截器拦截路径
        registry.addInterceptor(jzl1Interceptor).addPathPatterns("/**").excludePathPatterns();
        registry.addInterceptor(jzl2Interceptor).addPathPatterns("/**");
    }
}
