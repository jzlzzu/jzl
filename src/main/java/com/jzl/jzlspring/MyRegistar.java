package com.jzl.jzlspring;

import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.annotation.ImportBeanDefinitionRegistrar;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 9:44 2020/6/13
 * @Modified By:
 */
public class MyRegistar implements ImportBeanDefinitionRegistrar {
    @Override
    public void registerBeanDefinitions(AnnotationMetadata importingClassMetadata, BeanDefinitionRegistry registry) {
        System.out.println("开启@EnableJzl时 执行 MyRegistar 的 registerBeanDefinitions()方法");
    }
}
