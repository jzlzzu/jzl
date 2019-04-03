package com.jzl.design.proxy;

import org.springframework.cglib.proxy.InvocationHandler;
import org.springframework.cglib.proxy.Proxy;

import java.lang.reflect.Method;

/**
 * @Author: jzl
 * @Description: CGLIB实现动态代理
 * @Date: Created in 10:27 2019/4/3
 * @Modified By:
 */
public class CGLIBProxyTest {
    public static void main(String[] args) {
        ChaseGirlFriend chaseGirlFriend = new ChaseGirlFriendServiceImpl();
        ChaseGirlFriend proxyInstance = (ChaseGirlFriend) Proxy.newProxyInstance(chaseGirlFriend.getClass().getClassLoader(), new Class[]{ChaseGirlFriend.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
                System.out.println("送一辆golf");
                Object invoke = method.invoke(chaseGirlFriend, args);
                System.out.println("追到两个女朋友");
                return invoke;
            }
        });
        proxyInstance.chaseGirlFriend();
    }
}
