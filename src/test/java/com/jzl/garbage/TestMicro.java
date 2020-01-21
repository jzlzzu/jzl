package com.jzl.garbage;

import lombok.SneakyThrows;
import org.junit.Test;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.Collection;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 16:37 2020/1/4
 * @Modified By:
 */
public class TestMicro {

    @Test
    @SneakyThrows
    public void testAssert() {
        ArrayList<Object> list = new ArrayList<>();
        String a = "abc";
        String b = "";
        Assert.isNull(list,"list为空");
    }

    @Test
    @SneakyThrows
    public void name() {
        Collection collection = new ArrayList();
        collection.add(4);
        collection.add(2);
        collection.add(8);
        Collection collection2 = new ArrayList();
        collection2.add(2);
        collection2.add("abc");
        collection2.add('a');
        // 在调用者中  留下交集的部分
        boolean flag = collection.retainAll(collection2);
        System.out.println(flag);// 如果因为取交集删除元素了  true  没有删除元素   false
        System.out.println(collection);
    }
}
