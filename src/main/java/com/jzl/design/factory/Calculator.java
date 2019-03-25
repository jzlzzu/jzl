package com.jzl.design.factory;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 17:28 2019/3/19
 * @Modified By:
 */
public abstract class Calculator {

    public double a;
    public double b;

    public double getResult() {
        return 0;
    }

    public double getA() {
        return a;
    }

    public void setA(double a) {
        this.a = a;
    }

    public double getB() {
        return b;
    }

    public void setB(double b) {
        this.b = b;
    }


}
