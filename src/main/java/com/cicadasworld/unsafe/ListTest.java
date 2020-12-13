package com.cicadasworld.unsafe;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.Vector;
import java.util.concurrent.CopyOnWriteArrayList;

public class ListTest {

    // java.util.ConcurrentModificationException 并发修改异常
    public static void main(String[] args) {

        // solution:
        // 1. List<String> list = new Vector<>();
        // 2. List<String> list = Collections.synchronizedList(new ArrayList<>());
        // 3. List<String> list = new CopyOnWriteArrayList<>();
        // CopyOnWrite COW 计算机程序领域的一种优化策略
        List<String> list = new CopyOnWriteArrayList<>();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                list.add(UUID.randomUUID().toString().substring(0, 5));
                System.out.println(list);
            }, i + "").start();
        }
    }
}
