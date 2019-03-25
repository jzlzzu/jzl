package com.jzl.design.strategy;

/**
 * @Author: jzl 策略模式结合工厂模式
 * @Description:
 * @Date: Created in 19:44 2019/3/19
 * @Modified By:
 */
public class CashContext {
    CashStrategy cashStrategy = null;

    public CashContext() {
    }

    //    public CashContext(CashStrategy cashStrategy) {
//        this.cashStrategy = cashStrategy;
//    }
    public CashContext(String type) {
        switch (type) {
            case "dazhe":
                cashStrategy = new CashRebate();
                ((CashRebate) cashStrategy).setDazheMoney(0.5);
                break;
            case "fanxian":
                cashStrategy = new CashReturn();
                ((CashReturn) cashStrategy).setFullMoney(1000);
                ((CashReturn) cashStrategy).setDelMoney(300);
                break;
            default:
                cashStrategy = new CashNormal();
                break;
        }
        return;
    }

    public double getResult(double money) {
        return cashStrategy.acceptCash(money);
    }

}
