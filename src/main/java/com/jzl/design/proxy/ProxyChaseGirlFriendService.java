package com.jzl.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 8:57 2019/4/3
 * @Modified By:
 */
public class ProxyChaseGirlFriendService implements InvocationHandler {

    private Object obj ;

    public ProxyChaseGirlFriendService() {
    }

    public ProxyChaseGirlFriendService(Object obj) {
        this.obj = obj;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("送跑车");
        Object invoke = method.invoke(obj, args);
        System.out.println("成功追到");
        return invoke;
    }
}
