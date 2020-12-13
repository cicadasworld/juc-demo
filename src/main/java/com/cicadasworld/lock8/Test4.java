package com.cicadasworld.lock8;

import java.util.concurrent.TimeUnit;

public class Test4 {

    public static void main(String[] args) {
        Phone4 phone = new Phone4();
        new Thread(() -> phone.sendSms(), "A").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(() -> phone.call(), "B").start();
    }
}

class Phone4 {

    public static synchronized void sendSms() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("发短信");
    }

    public static synchronized void call() {
        System.out.println("打电话");
    }
}
