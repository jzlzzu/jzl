package com.jzl.design.decorate;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 12:59 2019/3/27
 * @Modified By:
 */
public class ConcreteDecorateB extends Clothes {

    @Override
    public void show() {
        System.out.println("穿上衣");
        super.show();
    }
}
