package com.cicadasworld.jmm;

import java.util.concurrent.TimeUnit;

/**
 *   ---------------------------------------
 *   |             字节码执行引擎             |
 *   ---------------------------------------
 *         |                          |
 *   ---------------------------------------
 *   |     |                          |    |
 *   |   assign ------------------- use    |
 *   |     |                          |    |
 *   |   store -------------------- load   |
 *   |     |                          |    |
 *   ------|--------------------------------
 *         |                          |
 *   -----write---------------------read----
 *   |                                     |
 *   |     lock     JVM主内存      unlock   |
 *   |                                     |
 *   ---------------------------------------
 *
 */
public class VolatileTest {

    // 不加volatile程序死循环
    private volatile static int num = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            while (num == 0) {

            }
        }).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        num = 1;
        System.out.println(num);
    }
}
