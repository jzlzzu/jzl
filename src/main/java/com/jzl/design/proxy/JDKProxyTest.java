package com.jzl.design.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @Author: jzl
 * @Description: jdk动态代理方式
 * @Date: Created in 9:15 2019/4/3
 * @Modified By:
 */
public class JDKProxyTest {
    public static void main(String[] args) {
        //不使用匿名内部类
//        noniming();
        niming();
    }

    /**
     * 匿名内部类方式
     */
    private static void niming() {
        ChaseGirlFriend chaseGirlFriendService = new ChaseGirlFriendServiceImpl();
        ChaseGirlFriend proxy = (ChaseGirlFriend) Proxy.newProxyInstance(chaseGirlFriendService.getClass().getClassLoader(), new Class[]{ChaseGirlFriend.class}, new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("送豪宅");
                Object invoke = method.invoke(chaseGirlFriendService, args);
                System.out.println("success追到");
                return invoke;
            }
        });
        proxy.chaseGirlFriend();
    }

    /**
     * 非匿名内部类方式
     */
    private static void noniming() {
        ChaseGirlFriend chaseGirlFriendService = new ChaseGirlFriendServiceImpl();
        ProxyChaseGirlFriendService proxyChaseGirlFriendService = new ProxyChaseGirlFriendService(chaseGirlFriendService);
//        Class[] classes = {ChaseGirlFriend.class};
        ChaseGirlFriend proxyInstance = (ChaseGirlFriend) Proxy.newProxyInstance(chaseGirlFriendService.getClass().getClassLoader(),
                chaseGirlFriendService.getClass().getInterfaces(), proxyChaseGirlFriendService);
        proxyInstance.chaseGirlFriend();
    }
}
