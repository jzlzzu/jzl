package com.jzl.design;

import com.jzl.design.factory.Calculator;
import com.jzl.design.factory.CalculatorFactory;
import com.jzl.design.strategy.CashContext;
import org.junit.Test;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 17:24 2019/3/19
 * @Modified By:
 */
public class DesignTest {

    /**
     * 简单工厂类测试
     */
    @Test
    public void testSimpleFactory() {
        CalculatorFactory calculatorFactory = new CalculatorFactory();
        Calculator calculator = calculatorFactory.createCalculator("-");
        calculator.a = 10;
        calculator.b = 5;
        double result = calculator.getResult();
        System.out.println(result);
    }

    @Test
    public void testStrategy() {
        CashContext cashContext = new CashContext("dazhe");
        double result = cashContext.getResult(1000);
        System.out.println("打折后价钱_" + result);
        
    }
}
