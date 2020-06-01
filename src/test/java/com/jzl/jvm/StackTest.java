package com.jzl.jvm;

import java.util.ArrayList;

/**
 * @Author: jzl
 * @Description: 测试栈内存溢出异常
 * @Date: Created in 17:37 2020/4/22
 * @Modified By:
 */
public class StackTest {
    private int stackLength = -1;

    public void stackLeak() {
        stackLength++;
        // 递归调用，增加栈深度
        stackLeak();
    }

    public static void main(String[] args) {
        StackTest stackTest = new StackTest();
        try {
            stackTest.stackLeak();
        } catch (Exception e) {
            System.out.println(stackTest.stackLength);
            throw e;
        }
    }
}
