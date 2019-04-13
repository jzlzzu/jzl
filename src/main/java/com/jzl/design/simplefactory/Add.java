package com.jzl.design.simplefactory;

/**
 * @Author: jzl
 * @Description: 加法类
 * @Date: Created in 18:08 2019/3/19
 * @Modified By:
 */
public class Add extends Calculator {
    @Override
    public double getResult() {
        return a + b;
    }
}
