package com.cicadasworld.cas;

import java.util.concurrent.atomic.AtomicInteger;

// CAS: compare and set/swap, CAS是CPU的并发原言
public class CasTest {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);

        System.out.println(atomicInteger.compareAndSet(1, 2));
        System.out.println(atomicInteger.get());

        System.out.println(atomicInteger.compareAndSet(1, 2));
        System.out.println(atomicInteger.get());
    }
}
