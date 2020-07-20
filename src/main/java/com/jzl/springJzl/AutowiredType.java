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
public class AutowiredType {

    /**
     *  1. 反射获取Filed类 , 然后赋值
     */
//    @Autowired
    private AutowiredTypeService autowiredTypeService;

    /**
     * 2. 反射获取构造方法,然后赋值
     * @param autowiredTypeService
     */
    public AutowiredType(AutowiredTypeService autowiredTypeService) {
        System.out.println("---构造方法---");
        this.autowiredTypeService = autowiredTypeService;
    }

    /**
     * 反射获取set方法 , 然后赋值
     * @param autowiredTypeService
     */
//    @Autowired
    public void setAutowiredTypeService(AutowiredTypeService autowiredTypeService) {
        System.out.println("set方法 setAutowiredTypeService 执行");
        this.autowiredTypeService = autowiredTypeService;
    }

    public void query() {
        System.out.println("检查@注入对象是否为空 ----" + autowiredTypeService);
    }

}
