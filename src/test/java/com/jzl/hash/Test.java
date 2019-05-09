package com.jzl.hash;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 20:42 2019/5/9
 * @Modified By:
 */
public class Test {

    @org.junit.Test
    public void test1(){
        long jzl = ConsistentHash.md5HashingAlg("jzl");
        long jzl1 = ConsistentHash.fnv1HashingAlg("jzl");
        System.out.println(jzl);
        System.out.println(jzl1);
    }

}
