package com.jzl.spring;

import com.jzl.springJzl.AutowiredType;
import com.jzl.springJzl.AutowiredType2;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author:
 * @Description: 测试spring的注入方式 : 1. 反射获取set方法,然后调用set方法  2. 反射获取构造方法 , 然后调用构造方法 3, 反射获取field, 然后给field赋值
 * @Autowired 加载成员变量上 的注入方式 是 反射获取field, 类似 com.jzl.Jzl#reflect()
 * @Date: Created in 9:23 2020/7/16
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAutowiredType {

    @Autowired
    private AutowiredType2 autowiredType2;

    @Autowired
    private AutowiredType autowiredType;

    @Test
    public void test2(){
        autowiredType2.query();
    }

    @Test
    public void test(){
        autowiredType.query();
    }

}
