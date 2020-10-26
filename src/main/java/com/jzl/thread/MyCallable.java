package com.jzl.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

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

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        MyCallable myCallable = new MyCallable();
        FutureTask futureTask = new FutureTask<>(myCallable);
        new Thread(futureTask,"A").start();
        // 第二次并不会执行
        new Thread(futureTask,"B").start();

        System.out.println(futureTask.get());
        System.out.println(futureTask.get());

    }
}
