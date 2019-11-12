package com.jzl.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author: jzl
 * @Description: wait sleep join yield 的区别
 * @Date: Created in 14:52 2019/10/25
 * @Modified By:
 */
public class ThreadApiLearn {

    public static void main(String[] args) throws Exception {
        learnCountDownLatch();


        // 使用wait 和 notify实现 生产者 消费者线程
//        learnWaitNotify();
    }

    /**
     * 一个CountDownLatch会通过一个给定的count数来被初始化。其中await()方法会一直阻塞，直到当前的count被减到0，
     * 而这个过程是通过调用countDown()方法来实现的。在await()方法不再阻塞以后，所有等待的线程都会被释放，
     * 并且任何await()的子调用都会立刻返回。这是一次性的－－count不能被重置。如果你需要一种能重置count的版本，请考虑使用CyclicBarrier。
     *
     * @throws InterruptedException
     */
    private static void learnCountDownLatch() throws InterruptedException {
        // 学习并发包的 CountDownLatch 的 await() 和 countDown
        CountDownLatch countDownLatchA = new CountDownLatch(1);
        CountDownLatch countDownLatchB = new CountDownLatch(5);

        ExecutorService executorService = Executors.newFixedThreadPool(5);

        for (int i = 0; i < 5; i++) {
            executorService.submit(() -> {
                try {
                    // 阻塞当前线程,当count 为0 时,线程继续执行
                    System.out.println("线程阻塞啦");
                    countDownLatchA.await();
                    System.out.println("线程放行了");
                    countDownLatchB.countDown();
                    System.out.println("------" + countDownLatchB.getCount());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        System.out.println(countDownLatchA.getCount());
        // 调用countDown方法, 计数值 count -1 ; 此时count 为0 ,阻塞线程开始放行了
        countDownLatchA.countDown();

        //主线程等待countDownLatchB对应的 count为0时 , 完成结束
        countDownLatchB.await();
        System.out.println("finished");
    }

    /**
     * 使用wait 和 notify实现 生产者 消费者线程
     * 如果要使用wait和notify的话，那么必须在synchronized块中，否则会抛出IllegalMonitorStateException
     *
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
                        if (list.size() > 0) {
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
