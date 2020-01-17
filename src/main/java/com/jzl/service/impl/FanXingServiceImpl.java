package com.jzl.service.impl;

import com.jzl.service.FanXingInter;

/**
 * @Author: jzl
 * @Description: 不指定泛型类型实现接口
 * @Date: Created in 8:42 2019/4/13
 * @Modified By:
 */
public class FanXingServiceImpl<T> implements FanXingInter<T> {
    @Override
    public T t() {
        return null;
    }

    public <E> E method1(Class<E> e) throws IllegalAccessException, InstantiationException {
        E e1 = e.newInstance();
        return e1;
    }
}

/**
 * 指定泛型类型实现接口
 */
class FanXingServiceImpl1 implements FanXingInter<String> {
    @Override
    public String t() {
        return null;
    }
}
