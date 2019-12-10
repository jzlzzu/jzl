package com.jzl.design;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 17:38 2019/11/13
 * @Modified By:
 */
public class RedisLockUtil {


    public static <T> void executeSynchOperate(MainOperator<T> operator,String lockCache ){
        System.out.println("获取锁");
        operator.executeInvokeLogic(false);
        System.out.println("关闭锁");
    }


    // 返回值为T 不确定
    public abstract interface MainOperator<T> {
         T executeInvokeLogic(Boolean result);
    }



}
