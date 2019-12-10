package com.jzl.design;

import com.jzl.design.decorate.ConcreteDecorateA;
import com.jzl.design.decorate.Clothes;
import com.jzl.design.decorate.ConcreteDecorateB;
import com.jzl.design.decorate.Person;
import com.jzl.design.simplefactory.Calculator;
import com.jzl.design.simplefactory.CalculatorFactory;
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

    /**
     * 装饰者模式 : 不好理解啊
     */
    @Test
    public void testDecorate() {
        Person person = new Person("小明");
        Clothes clothes = new Clothes();
        ConcreteDecorateA concreteDecorateA = new ConcreteDecorateA();
        ConcreteDecorateB concreteDecorateB = new ConcreteDecorateB();

        clothes.decorate(person);
        concreteDecorateA.decorate(clothes);
        concreteDecorateB.decorate(concreteDecorateA);

        concreteDecorateB.show();
    }

    @Test
    public void testRedisLockTest() {
        RedisLockUtil.executeSynchOperate(new RedisLockUtil.MainOperator<Boolean>() {
            @Override
            public Boolean executeInvokeLogic(Boolean flag) {
                System.out.println("--------");
                return false;
            }
        },"lockCache");

    }
}
