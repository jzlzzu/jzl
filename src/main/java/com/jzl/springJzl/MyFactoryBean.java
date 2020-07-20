package com.jzl.springJzl;

import org.springframework.beans.factory.FactoryBean;

/**
 * @Author: jzl
 * @Description: factoryBean和beanFactory 有什么区别呢？
 * @Date: Created in 9:49 2020/5/26
 * @Modified By:
 */
public class MyFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return null;
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }
}
