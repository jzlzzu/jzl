package com.jzl.thread;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: jzl
 * @Description: wait sleep join yield 的区别
 * @Date: Created in 14:52 2019/10/25
 * @Modified By:
 */
public class ThreadApiLearn {

    public static void main(String[] args) throws Exception {
        learnWaitNotify();
    }

    /**
     * 利用wait 和 notify实现 生产者 消费者线程
     * 如果要使用wait和notify的话，那么必须在synchronized块中，否则会抛出IllegalMonitorStateException
     * @throws InterruptedException
     */
    private static void learnWaitNotify() throws InterruptedException {
        final Object obj = new Object();
        List<Object> list = new ArrayList<>();

        //消费者
        Thread t1 = new Thread(() -> {
            synchronized (obj) {
                try {
                    while (list.size() >= 0) {
                        if(list.size() > 0){
                            list.remove(0);
                            System.out.println("消费一条消息---------");
                        }
                        obj.notifyAll();
                        System.out.println("Thread 1 sent notify.");

                        System.out.println("Thread 1 wait.");
                        obj.wait();
                    }
                } catch (InterruptedException e) {
                }
                System.out.println("线程1运行结束");
            }
        });
        t1.start();


        //生产者
        Thread.sleep(1000);//We assume thread 1 must start up within 1 sec.
        Thread t2 = new Thread(() -> {
            synchronized (obj) {
                try {
                    while (list.size() <= 0) {
                        System.out.println("生产一条消息----------");
                        list.add("olleh");

                        obj.notifyAll();
                        System.out.println("Thread 2 sent notify.");

                        System.out.println("Thread 2 wait");
                        obj.wait();
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("线程2运行结束");
        });
        t2.start();
    }
}
