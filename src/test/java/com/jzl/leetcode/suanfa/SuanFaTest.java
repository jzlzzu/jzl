package com.jzl.leetcode.suanfa;

import org.junit.Test;

import java.util.Arrays;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 16:56 2020/7/27
 * @Modified By:
 */
public class SuanFaTest {

    /**
     * 数组反转
     */
    @Test
    public void test() {
        int a[] = {1, 2, 3, 4, 5, 6};

        int tmp;
        for (int i = 0; i < a.length / 2; i++) {
            tmp = a[i];
            a[i] = a[a.length - i - 1];
            a[a.length - i - 1] = tmp;
        }
        System.out.println(Arrays.toString(a));
    }

    /**
     * 链表
     */
    @Test
    public void max() {
        int a[] = {1,4,3};



    }
}
