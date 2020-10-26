package com.jzl.thread.lock;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 14:58 2020/8/7
 * @Modified By:
 */

import java.util.concurrent.TimeUnit;

/**
 * **1、标准访问，请问先打印邮件1还是短信2？**
 *
 *
 */
public class TestLock {
    // 回家  卧室(锁)   厕所
    public static void main(String[] args) {
        // 两个对象，互不干预
        Phone7 phone = new Phone7();

        // 我们这里两个线程使用的是同一个对象。两个线程是一把锁！先调用的先执行！
        new Thread(() -> { // 一开始就执行了
            phone.sendEmail();
        }, "A").start();

        // 干扰
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> { // 一秒后执行
            phone.sendMS();
        }, "B").start();

    }
}


class Phone7 {
    // CLASS
    public static synchronized void sendEmail() {
        // 善意的延迟
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("sendEmail");
    }

    // 对象
    // 普通同步方法
    public static synchronized void sendMS() {
        System.out.println("sendMS");
    }
}
