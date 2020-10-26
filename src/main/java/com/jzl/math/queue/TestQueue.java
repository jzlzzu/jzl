package com.jzl.math.queue;

import org.junit.Test;

import java.util.LinkedList;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 9:50 2020/8/27
 * @Modified By:
 */
public class TestQueue {

    @Test
    public void test(){
        // 约瑟夫环问题
        LinkedList<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        System.out.println(linkedList.poll());;

    }

}
