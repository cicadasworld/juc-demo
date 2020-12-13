package com.cicadasworld.util;

import java.util.concurrent.CountDownLatch;

// 减法计数器
public class CountDownLatchTest {

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(6);

        for (int i = 0; i < 6; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName());
                latch.countDown();
            }, String.valueOf(i)).start();
        }

        latch.await();

        latch.countDown();
    }
}
