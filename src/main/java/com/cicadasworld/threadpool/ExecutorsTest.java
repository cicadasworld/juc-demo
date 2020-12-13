package com.cicadasworld.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ExecutorsTest {

    public static void main(String[] args) {
//        ExecutorService threadPool = Executors.newSingleThreadExecutor();
//        ExecutorService threadPool = Executors.newFixedThreadPool(5);
//        ExecutorService threadPool = Executors.newCachedThreadPool();

        // 关于最大线程数的设置策略
        // CPU 密集型, 几个核设置几个
        int processors = Runtime.getRuntime().availableProcessors();

        // IO 密集型 判断 耗IO的线程 *2

        // 类比 去银行办理业务
        ExecutorService threadPool = new ThreadPoolExecutor(
                2,  // 通常开放窗口
                processors, // 最大开放窗口
                3, TimeUnit.SECONDS, // 超过一定时间，回到通常开放窗口数
                new LinkedBlockingQueue<Runnable>(3), // 候客区
                Executors.defaultThreadFactory(), // 默认线程工厂, 一般不改动
                new ThreadPoolExecutor.AbortPolicy()); // 拒绝策略
        // AbortPolicy, 超过线程最大数会抛出异常
        // CallerRunsPolicy
        // DiscardPolicy
        // DiscardOldestPolicy

        try {
            for (int i = 0; i < 10; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName());
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

    }
}
