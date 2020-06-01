package com.jzl.thread.lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 11:24 2020/5/6
 * @Modified By:
 */
public class Item {
    private int num = 0;
    ReentrantLock reentrantLock = new ReentrantLock();
    Condition condition = reentrantLock.newCondition();
    public void add() throws InterruptedException {
        reentrantLock.lock();
        while (num != 0){
            condition.await();
        }
        System.out.println(++num);
        condition.signalAll();
        reentrantLock.unlock();
    }


    public void del() throws InterruptedException {
        reentrantLock.lock();
        while (num == 0){
            condition.await();
        }
        System.out.println(--num);
        condition.signalAll();
        reentrantLock.unlock();
    }
}
