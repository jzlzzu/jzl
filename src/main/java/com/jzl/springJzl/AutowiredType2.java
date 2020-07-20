package com.jzl.springJzl;

import com.jzl.service.AutowiredTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 9:05 2020/7/16
 * @Modified By:
 */
@Component
public class AutowiredType2 {

    private AutowiredTypeService autowiredTypeService;

    /**
     * 默认会调用该方法
     * @param autowiredTypeService
     */
    public AutowiredType2(AutowiredTypeService autowiredTypeService) {
        System.out.println("-----AutowiredType2 构造方法执行--------");
        this.autowiredTypeService = autowiredTypeService;
    }

    /**
     * 在com.jzl.springJzl.MyBeanPostFactoryProcessor中修改autowiredType.setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE);
     * 此时不需要写@Autowired 也不需要配置xml文件, 既可以完成成员变量AutowiredTypeService的注入
     * @param autowiredTypeService
     */
    public void setAutowiredTypeService(AutowiredTypeService autowiredTypeService) {
        System.out.println("set方法 setAutowiredTypeService 执行");
        this.autowiredTypeService = autowiredTypeService;
    }

    public void query() {
        System.out.println("检查@注入对象是否为空 ----" + autowiredTypeService);
    }

    /**
     * 该set方法不会执行
     */
    public void setJzl() {
        System.out.println("----------------setJzl没有参数,所以执行set无实际意义----------------------");
    }

    /**
     * 该set方法会执行
     * @param autowiredTypeService
     */
    public void setJzl(AutowiredTypeService autowiredTypeService) {
        System.out.println("----------------setJzl有参数,且参数在spring中-----------------------");
    }

}
