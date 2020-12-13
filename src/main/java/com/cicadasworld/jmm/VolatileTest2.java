package com.cicadasworld.jmm;

import java.util.concurrent.atomic.AtomicInteger;

public class VolatileTest2 {

    //    private volatile static int num = 0;
    private volatile static AtomicInteger num = new AtomicInteger();

    public static void add() {
//        num++; // 不是一个原子性操作
        num.getAndIncrement(); // CAS: compare and set
    }

    public static void main(String[] args) {
        for (int i = 0; i < 20; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    add();
                }
            }).start();
        }
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(Thread.currentThread().getName() + ": " + num);
    }
}
