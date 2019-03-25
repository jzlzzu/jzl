package com.jzl.design.strategy;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 19:34 2019/3/19
 * @Modified By:
 */
public class CashRebate extends CashStrategy {

    /**
     * 打折
     */
    public double dazheMoney;

    @Override
    double acceptCash(double money) {
        System.out.println("打折销售");
        return money * dazheMoney;
    }

    public void setDazheMoney(double dazheMoney) {
        this.dazheMoney = dazheMoney;
    }
}
