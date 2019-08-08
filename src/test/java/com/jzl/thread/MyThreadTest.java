package com.jzl.thread;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 11:00 2019/8/8
 * @Modified By:
 */
public class MyThreadTest extends Thread {

    /**
     * 不加 volatile 线程不会停下来
     * 为什么呢?
     * java中有一块主内存，每个线程都有自己单独的工作内存，
     * 每个变量在主内存中有一个值。如果线程有使用到该变量，
     * 则该线程工作内存中会存在一个该变量的拷贝。
     * 当线程结束时会将线程工作内存中的变量拷贝同步回主内存。
     */
//        private boolean isRunning=true;
        volatile private boolean isRunning=true;

        public boolean isRunning() {
            return isRunning;
        }

        public void setRunning(boolean isRunning) {
            this.isRunning = isRunning;
        }

        @Override
        public void run() {
            System.out.println("进入了run");
            while(isRunning){

            }
            System.out.println("结束");
        }

        public static void main(String[] args) {
            try {
                MyThreadTest t = new MyThreadTest();
                t.start();
                Thread.sleep(100);
                t.setRunning(false);
                System.out.println("isRunning设置成false");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
}
