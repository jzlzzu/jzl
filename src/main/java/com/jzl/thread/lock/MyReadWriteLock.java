package com.jzl.thread.lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 10:41 2020/4/7
 * @Modified By:
 */
public class MyReadWriteLock {
    public static void main(String[] args) throws InterruptedException {
        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                // lock.lock 加锁
                System.out.println(Thread.currentThread().getName());
                readWriteLock.writeLock().lock();
                try {
//                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    readWriteLock.writeLock().unlock(); // lck.unlock();
                }
            }).start();
        }

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                // lock.lock 加锁
                System.out.println(Thread.currentThread().getName()+"xie----");
                readWriteLock.readLock().lock();
                try {
//                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    readWriteLock.readLock().unlock(); // lck.unlock();
                }
            }).start();
        }

        Thread.sleep(10000);
    }
}
