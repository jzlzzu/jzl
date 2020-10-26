package com.jzl.math;

import java.util.Arrays;
import java.util.Random;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 11:08 2019/11/15
 * @Modified By:
 */
public class Sort {

    public static void main(String[] args) {
//        int[] array = {3, 5, 1, 4, 2, 7, 4, 6, 9};
        int[] array = {2, 3, 1, 9, 4, 1};
        //冒泡排序
        maopao(array);


        //简单选择排序: 第一次遍历: 选择最小的,把最小的和最左侧交换
//        selectSort(array);

        // 优化选择排序 : 不用频繁交换,只需要找出最小值对应的下标, 然后将最小值交换到首部
//        selectionSort(array);

//        selectionSort1(array);


        // 快速排序
//        quickSort(array, 0, array.length - 1);


        // partition
//        partition(array, 0, array.length - 1, 4);


        System.out.println(Arrays.toString(array));
    }

    private static void quickSort(int[] array, int L, int R) {

        if (L < R) {
            // 把数组中随机的一个元素与最后一个元素交换，这样以最后一个元素作为基准值实际上就是以数组中随机的一个元素作为基准值
//            swap(array, new Random().nextInt(R - L + 1) + L, R);
            int[] p = partition(array, L, R);
            System.out.println(Arrays.toString(array));
            quickSort(array, L, p[0] - 1);
            quickSort(array, p[1] + 1, R);
        }

    }

    public static int[] partition(int[] arr, int L, int R) {

        int basic = arr[R];
        int less = L - 1;
        int more = R + 1;
        while (L < more) {
            if (arr[L] < basic) {
                swap(arr, ++less, L++);
            } else if (arr[L] > basic) {
                swap(arr, --more, L);
            } else {
                L++;
            }
        }

        return new int[]{less + 1, more - 1};

    }

    private static void partition(int[] array, int L, int R, int p) {
//        https://www.jianshu.com/p/356604b8903f
//        其中存在错误部分
        //如果 arr[L] < 4, 交换 arr[++ less] 和 arr[L++] 的值
        //如果 arr[L] > 4, 交换 arr[--more] 和 arr[L] 的值

        int less = L - 1;
        int more = R + 1;

        while (L < more) {
            if (array[L] > p) {
                swap(array, --more, L);
            } else if (array[L] < p) {
                swap(array, ++less, L++);
            } else {
                L++;
            }
        }
    }


    public static void selectionSort(int[] nums) {

        if (nums == null || nums.length < 2) {
            return;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                // 找到最小数值的下标
                if (nums[i] > nums[j]) {
                    minIndex = nums[j] < nums[minIndex] ? j : minIndex;
                }
            }
            swap(nums, i, minIndex);
            System.out.println(Arrays.toString(nums));
        }

    }

    public static void selectionSort1(int[] nums) {

        if (nums == null || nums.length < 2) {
            return;
        }

        for (int i = 0; i < nums.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                // 找到最小数值的下标
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            swap(nums, i, minIndex);
            System.out.println(Arrays.toString(nums));
        }

    }

    private static void selectSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] > array[j]) {
                    swap(array, i, j);
                }
            }
            System.out.println(Arrays.toString(array));
        }
    }


    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    /**
     * 冒泡排序
     *
     * @param array
     */
    private static void maopao(int[] array) {
        for (int i = 0; i < array.length; i++) {
            boolean flag = true;
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    //大于右边的则交换位置
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                    flag = false;
                }
            }
            System.out.println(i + "   " + Arrays.toString(array));
            if (flag) {
                break;
            }
        }
    }
}
