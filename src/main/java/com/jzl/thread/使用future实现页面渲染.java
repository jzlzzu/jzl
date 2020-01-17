package com.jzl.thread;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: jzl
 * @Description:
 * @Date: Created in 10:59 2019/11/28
 * @Modified By:
 */
public class 使用future实现页面渲染 {

    private static final ExecutorService executorService = Executors.newCachedThreadPool();


    static void renderPage() throws ExecutionException, InterruptedException {
        ExecutorCompletionService<String> executorCompletionService = new ExecutorCompletionService(executorService);

        executorCompletionService.submit(() -> {

            System.out.println("执行任务逻辑");
            return "ok";
        });

        List<String> list = new ArrayList<>();
        Future<List<String>> listFuture = executorService.submit(() -> {
            for (int i = 0; i < 10; i++) {
                list.add("olleh" + i);
            }
//                TimeUnit.SECONDS.sleep(20);
            return list;
        });

        // listFuture.get()方法会阻塞当前线程
        List<String> stringList = listFuture.get();
        System.out.println("任务执行结束");
    }


    public static void main(String[] args) throws ExecutionException, InterruptedException {
        renderPage();
    }


}
