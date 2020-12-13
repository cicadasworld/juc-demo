package com.cicadasworld.unsafe;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArraySet;

public class SetList {

    public static void main(String[] args) {
        // 1. Set<String> set = Collections.synchronizedSet(new HashSet<>());
        // 2. Set<String> set = new CopyOnWriteArraySet<>();
        // HashSet 的底层是 HashMap
        // HashSet的 add 方法
        // public boolean add(E e) {
        //     return map.put(e, PRESENT)==null;
        // }

        Set<String> set = new CopyOnWriteArraySet<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                set.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(set);
            }, i + "").start();
        }
    }
}
