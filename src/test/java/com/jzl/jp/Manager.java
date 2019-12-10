package com.jzl.jp;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 11:10 2019/11/14
 * @Modified By:
 */
public class Manager {

    Object object = new Object();

    public static ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();

    @Test
    public void name() throws InterruptedException {
        new Thread(() -> {
            ObjectMapper mapper = new ObjectMapper();
            synchronized (object) {
                while (true) {
                    try {
                        String mapStr = mapper.writeValueAsString(concurrentHashMap);
                        System.out.println(mapStr);
                        object.notifyAll();
                        object.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        Thread.sleep(5000);

        new Thread(() -> {
            synchronized (object) {
                for (int i = 0; i < 10; i++) {
                    try {

                        concurrentHashMap.put("key" + i, "value" + i);
                        System.out.println("加入一名队员" + "key" + i);
                        object.notifyAll();
                        object.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        // 线程实例阻塞当前线程
        Thread.currentThread().join();
        System.out.println("线程结束");


    }
}
