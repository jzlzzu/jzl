package com.jzl.lambda;

import com.jzl.entity.Tree;
import com.jzl.entity.Weather;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 15:24 2020/6/10
 * @Modified By:
 */
public class TestOptional {

    @Test
    public void name() {

        Tree tree = new Tree();
        tree.setColor("red");
        tree.setHigh("100m");

        boolean empty = Optional.ofNullable(null).isPresent();
        boolean notempty = Optional.ofNullable(tree).isPresent();
        System.out.println(empty);

//        --------------optional设置默认值------------

        // tree为空时,执行并返回createTree()
        // tree不为空时, 返回tree并执行createTree()
        System.out.println(".......orElse..........");
        Optional.ofNullable(tree).orElse(createTree());


        // tree为空时,执行并返回createTree()
        // tree不为空时, 返回tree但是不执行createTree()
        System.out.println(".......orElseGet..........");
        Optional.ofNullable(tree).orElseGet(this::createTree);


        Optional.ofNullable(null).orElseThrow(()->new RuntimeException("olleh"));

        System.out.println(Optional.ofNullable(null).isPresent());

        //---------------转换值---------------------



    }

    @Test
    public void ttt() {
        ArrayList<Weather> list = LambdaTest.getList();
        Optional<String> any = list.stream().parallel().map(w -> w.getCity()).findAny();
        any.get();

    }

    public Tree createTree(){
        System.out.println("create tree");
        return new Tree();
    }


}
