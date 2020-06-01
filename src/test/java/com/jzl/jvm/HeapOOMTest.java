package com.jzl.jvm;

import java.util.ArrayList;

/**
 * @Author: jzl
 * @Description: 测试堆内存溢出异常
 * @Date: Created in 16:40 2020/4/22
 * @Modified By:
 */
public class HeapOOMTest {
    static class OOMObject{

    }

    /**
     * 设置堆内存20m  出现异常时储存堆栈信息镜像
     * -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
     * 将对象添加到list保持引用，避免GC回收
     * @param args
     */
    public static void main(String[] args) {
        ArrayList<OOMObject> objects = new ArrayList<>();
        while (true){
            objects.add(new OOMObject());
        }
    }
}
