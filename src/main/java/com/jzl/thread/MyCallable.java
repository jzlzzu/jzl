package com.jzl.thread;

import java.util.concurrent.Callable;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 17:55 2019/9/17
 * @Modified By:
 */
public class MyCallable implements Callable {
    @Override
    public Object call() throws Exception {
        System.out.println("I am callable");
        return "callable";
    }
}
