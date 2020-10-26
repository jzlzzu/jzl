package com.jzl.thread;

import java.util.concurrent.TimeUnit;

/**
 * @Author: jzl
 * @Description: 守护线程
 * @Date: Created in 8:04 2020/9/23
 * @Modified By:
 */
public class DaemonThread {

    public static void main(String[] args) {
        Thread thread1 = new Thread(() -> {
            System.out.println("-------start--------");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("-------end--------");
        });

        Thread daemonThread = new Thread(() -> {
            while (true){
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("-------i am 守护线程--------");
            }
        });

        // 将该线程设置为守护线程
        daemonThread.setDaemon(true);

        // 启动线程
        thread1.start();

        // 启动守护线程 , 当thread1运行结束时, 守护线程停止
        daemonThread.start();

        System.out.println(" i am main thread");
    }
}
