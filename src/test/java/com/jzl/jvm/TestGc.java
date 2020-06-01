package com.jzl.jvm;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 15:09 2020/4/23
 * @Modified By:
 */
public class TestGc {

    private static final int _1MB = 1024 * 1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static TestGc testGc = null;

    public static void main(String[] args) throws InterruptedException {
        testGc = new TestGc();
        testGc = null;
        System.gc();
        TimeUnit.MILLISECONDS.sleep(500);
        if(testGc !=null){
            System.out.println("alive");
        }else{
            System.out.println("dead");
        }
    }

}
