package com.jzl.design.simplefactory;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 18:10 2019/3/19
 * @Modified By:
 */
public class CalculatorFactory {
   public Calculator createCalculator(String type) {
        Calculator calculator;
        switch (type) {
            case "+":
                calculator = new Add();
                break;
            default:
                calculator = new Subtraction();
        }
        return calculator;
    }
}
