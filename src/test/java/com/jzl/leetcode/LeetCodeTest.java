package com.jzl.leetcode;

import org.junit.Test;

import java.math.BigInteger;
import java.util.Scanner;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 15:49 2019/12/23
 * @Modified By:
 */
public class LeetCodeTest {

    /**
     * 整数反转
     *
     * @param x
     * @return
     */
    int reverse(int x) {
        int max = 0x7fffffff, min = 0x80000000;//int的最大值最小值
        long rs = 0;//用long类型判断溢出
        while (x != 0) {
            rs = rs * 10 + x % 10;
            x /= 10;
        }
        return rs > max || rs < min ? 0 : (int) rs;//超了最大值低于最小值就返回0

    }

    /**
     * 回文数
     */
    public boolean isPalindrome(int x) {

        while (x > 0) {
            x = x / 10;
        }


        return false;
    }

    @Test
    public void name() {
        // 整数反转
        int reverse = reverse(123);
        System.out.println(reverse);


    }
}
