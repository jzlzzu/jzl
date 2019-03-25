package com.jzl.design.strategy;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 19:33 2019/3/19
 * @Modified By:
 */
public class CashNormal extends CashStrategy {
    @Override
    double acceptCash(double money) {
        System.out.println("正常消费");
        return money;
    }
}
