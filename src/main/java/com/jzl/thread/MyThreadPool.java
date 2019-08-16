package com.jzl.thread;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 15:16 2019/3/13
 * @Modified By:
 */

public class MyThreadPool {

    /**
     * 核心线程数
     */
    private static int corePoolSize = 8;

    /**
     * 最大线程数
     */
    private static int maximumPoolSize = 20;

    /**
     * 空闲线程最大存活时间
     */
    private static long keepAliveTime = 30000;

    private static final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maximumPoolSize, keepAliveTime,
            TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(100),new ThreadPoolExecutor.DiscardOldestPolicy());


    public static void main(String[] args) {
        for(;;){
            threadPoolExecutor.allowCoreThreadTimeOut(false);
            //没有返回值
            threadPoolExecutor.execute(() -> {
                System.out.println("线程池测试");
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            System.out.println(threadPoolExecutor.getTaskCount());;

//            //有返回值
//            Future<Boolean> 线程池测试2 = threadPoolExecutor.submit(() -> {
//                System.out.println("线程池测试2");
//                return true;
//            });
        }
    }

}
