package com.jzl.poi;

import org.junit.Test;

/**
 * @Author: jzl
 * @Description: 冒泡排序
 * @Date: Created in 14:49 2019/4/13
 * @Modified By:
 */
public class Sort {

    @Test
    public void testMaoPaoSort() {
        int[] nums = {23, 12, 34, 2, 67};
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 0; j < nums.length - i - 1; j++) {
                if (nums[j] > nums[j + 1]) {
                    int tmp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = tmp;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    /**
     * 快速排序
     */
    @Test
    public void testQuickSort(){

    }

}
