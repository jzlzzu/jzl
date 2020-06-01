package com.jzl.thread.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 10:56 2020/5/6
 * @Modified By:
 */
public class MyLock {
    public static void main(String[] args) {
        Item item = new Item();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    item.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    item.del();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();

    }

}
