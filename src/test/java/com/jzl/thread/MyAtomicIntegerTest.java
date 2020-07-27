package com.jzl.thread;

import com.jzl.entity.Weather;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 17:10 2020/4/7
 * @Modified By:
 */
public class MyAtomicIntegerTest {

    private final AtomicBoolean refreshed = new AtomicBoolean();

    @Test
    public void testAtomicBoolean() {
        if(this.refreshed.compareAndSet(false,true)){
            System.out.println("--------");
        }
    }

    @Test
    public void testAtomicInteger() {
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.addAndGet(1);
        System.out.println(atomicInteger);
        atomicInteger.addAndGet(1);
        System.out.println(atomicInteger);

        atomicInteger.compareAndSet(2,3);
        System.out.println(atomicInteger);
    }

    @Test
    public void testAtomicStampedReference() {

        Weather weather = new Weather();
        Weather weather1 = new Weather();
        weather1.setWeather("olleh");
        AtomicStampedReference<Weather> objectAtomicStampedReference = new AtomicStampedReference<>(weather,1);
        objectAtomicStampedReference.compareAndSet(weather,weather1,1,2);

        System.out.println(objectAtomicStampedReference.getReference());


    }
}
