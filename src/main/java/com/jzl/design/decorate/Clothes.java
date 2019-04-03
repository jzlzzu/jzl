package com.jzl.design.decorate;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 12:48 2019/3/27
 * @Modified By:
 */
public class Clothes extends Person{

    private Person person;

    public Clothes(){

    }

    public void decorate(Person person) {
        this.person = person;
    }

    @Override
    public void show() {
        if(person != null){
            person.show();
        }
    }
}
