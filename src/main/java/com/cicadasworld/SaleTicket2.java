package com.cicadasworld;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SaleTicket2 {
    public static void main(String[] args) {
        // 并发： 多线程操作同一个资源类, 把资源类丢入线程
        Ticket2 ticket = new Ticket2();
        new Thread(() -> { for (int i = 0; i < 40; i++) ticket.sale(); }, "A").start();
        new Thread(() -> { for (int i = 0; i < 40; i++) ticket.sale(); }, "B").start();
        new Thread(() -> { for (int i = 0; i < 40; i++) ticket.sale(); }, "C").start();
    }
}

// 资源类 OOP
class Ticket2 {
    private int number = 30;

    private Lock lock = new ReentrantLock();

    public void sale() {
        lock.lock();
        try {
            if (number > 0) {
                System.out.println(Thread.currentThread().getName() + "卖出了" + (number--) + "票，剩余：" + number);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}