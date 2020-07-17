package com.jzl.spring;

import com.jzl.jzlspring.AutowiredType;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 9:23 2020/7/16
 * @Modified By:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestAutowiredType {

    @Autowired
    private AutowiredType autowiredType;

    @Test
    public void test(){
        autowiredType.query();
    }

}
