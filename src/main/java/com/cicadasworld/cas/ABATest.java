package com.cicadasworld.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class ABATest {

    public static void main(String[] args) {
        AtomicStampedReference<Integer> asr = new AtomicStampedReference<>(1, 1);

        new Thread(() -> {
            int stamp = asr.getStamp(); // 获取版本号
            System.out.println("a1: " + stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(asr.compareAndSet(1, 2, asr.getStamp(), asr.getStamp() + 1));
            System.out.println("a2: " + asr.getStamp());

            System.out.println(asr.compareAndSet(2, 1, asr.getStamp(), asr.getStamp() + 1));
            System.out.println("a3: " + asr.getStamp());

        }, "a").start();
        new Thread(() -> {
            int stamp = asr.getStamp();
            System.out.println("b1: " + stamp);

            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(asr.compareAndSet(1, 6, asr.getStamp(), asr.getStamp() + 1));
            System.out.println("b2: " + asr.getStamp());

        }, "b").start();
    }
}
