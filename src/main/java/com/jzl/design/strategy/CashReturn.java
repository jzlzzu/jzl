package com.jzl.design.strategy;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 19:35 2019/3/19
 * @Modified By:
 */
public class CashReturn extends CashStrategy {
    /**
     * 满减
     */
    public double fullMoney;

    /**
     * 减
     */
    public double delMoney;
    /**
     * 应该
     */
    public double shouldMoney;

    @Override
    double acceptCash(double money) {
        shouldMoney = money;
        System.out.println("满减销售");
        if (money > fullMoney) {
            shouldMoney = money - delMoney;
        }
        return shouldMoney;
    }

    public void setFullMoney(double fullMoney) {
        this.fullMoney = fullMoney;
    }

    public void setDelMoney(double delMoney) {
        this.delMoney = delMoney;
    }
}
