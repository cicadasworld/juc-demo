package com.cicadasworld.reentrantlock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

// 自旋锁
public class SpinLockTest {

    AtomicReference<Thread> atomicReference = new AtomicReference<>();

    // 上锁
    public void myLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + ": mylock");
        while (atomicReference.compareAndSet(null, thread)) {

        }
    }

    // 解锁
    public void myUnLock() {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + ": myUnlock");
        atomicReference.compareAndSet(thread, null);
    }

    public static void main(String[] args) {
        SpinLockTest lock = new SpinLockTest();

        new Thread(() -> {
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }
        }, "t1").start();
        new Thread(() -> {
            lock.myLock();
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.myUnLock();
            }
        }, "t2").start();
    }
}
