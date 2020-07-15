package com.jzl.lambda;

import com.baomidou.mybatisplus.autoconfigure.ConfigurationCustomizer;
import com.jzl.entity.Weather;
import org.junit.Test;
import org.springframework.beans.factory.ObjectFactory;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 10:23 2019/12/10
 * @Modified By:
 */

public class FunctionInterTest {


    @Test
    public void name() {

        testJdk8(()->{
            System.out.println("olleh----------");
            return "olleh";
        });
    }

    public void testJdk8(ObjectFactory<?> objectFactory){
        System.out.println("=----------------");
        Set<Object> objects = new HashSet<>();
//        objectFactory.getObject();
        objects.add(objectFactory);
        System.out.println(objectFactory);
        System.out.println("=----------------++++++++");

    }

    @Test
    public void testConsumers() {
        ArrayList<Weather> list = LambdaTest.getList();
    }


}
