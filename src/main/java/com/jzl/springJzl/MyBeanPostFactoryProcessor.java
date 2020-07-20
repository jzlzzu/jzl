package com.jzl.springJzl;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.stereotype.Component;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 15:35 2020/7/20
 * @Modified By:
 */
@Component
public class MyBeanPostFactoryProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        GenericBeanDefinition autowiredType = (GenericBeanDefinition) beanFactory.getBeanDefinition("autowiredType2");
        autowiredType.setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE);
    }
}
