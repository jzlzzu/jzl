package com.jzl;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 18:23 2020/7/28
 * @Modified By:
 */
public class syn {
    public synchronized static void test1(){
        System.out.println("---");
    }

    public synchronized  void test2(){
        System.out.println("---");
    }

    public synchronized  void test3(){
        synchronized (this){
            System.out.println("-------");
        }
    }
}
