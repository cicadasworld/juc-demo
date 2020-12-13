package com.cicadasworld.future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

/**
 * 异步回调 CompletableFuture<T> 类比 ajax
 * 1. 异步执行
 * 2. 成功回调
 * 3. 失败回调
 */
public class FutureTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

//        Future<Void> future = CompletableFuture.runAsync(() -> {
//            try {
//                TimeUnit.SECONDS.sleep(2);
//                System.out.println(Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        });
//
//        System.out.println("=================");
//
//        future.get(); // 阻塞获取执行结果

        CompletableFuture<Integer> future = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName());
            int i = 10 / 0;
            return 1024;
        });

        Integer ret = future.whenComplete((t, u) -> {
            System.out.println("t: " + t); // 正常返回结果
            System.out.println("u: " + u); // 错误信息: java.util.concurrent.CompletionException
        }).exceptionally(e -> {
            System.out.println(e.getMessage());
            return 1024;
        }).get();
        System.out.println(ret);
    }
}
