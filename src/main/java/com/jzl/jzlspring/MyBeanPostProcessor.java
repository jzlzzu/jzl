package com.jzl.jzlspring;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Author: jzl
 * @Description: 后置处理器
 * @Date: Created in 9:48 2020/5/26
 * @Modified By:
 */
@Component
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        // 后置处理器 可以对bean随意修改 比如 bean = new ...;
//        System.out.println("--------------MyBeanPostProcessor---postProcessBeforeInitialization----------");
        return null;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
//        System.out.println("--------------MyBeanPostProcessor----postProcessAfterInitialization---------");
        return null;
    }
}
