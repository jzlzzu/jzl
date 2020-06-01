package com.jzl.jvm;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 14:47 2020/4/26
 * @Modified By:
 */
public class TestObjAge {

    private static final int _1MB = 1024 * 1024;

    public static void main(String[] args) throws InterruptedException {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[_1MB / 4];
        allocation3 = new byte[_1MB * 4];
        allocation4 = new byte[_1MB * 4];
        allocation4 = null;
        allocation4 = new byte[_1MB * 4];
        Thread.sleep(10000);
    }

}
