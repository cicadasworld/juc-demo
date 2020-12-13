package com.cicadasworld.lock8;

import java.util.concurrent.TimeUnit;

public class Test2 {

    public static void main(String[] args) {
        Phone2 phone = new Phone2();
        new Thread(() -> phone.sendSms(), "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> phone.call(), "B").start();
    }
}

class Phone2 {

    public synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    // 普通非同步方法
    public void call() {
        System.out.println("打电话");
    }
}
