package com.cicadasworld.forkjoin;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

public class Test {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        test1();
        // test2();
        // test3();
    }

    public static void test1() {
        long start = System.currentTimeMillis();

        long sum = 0L;
        for (int i = 1; i <= 10_0000_0000; i++) {
            sum += i;
        }

        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + ", elapsed time: " + (end - start));
    }

    public static void test2() throws ExecutionException, InterruptedException {
        long start = System.currentTimeMillis();

        ForkJoinPool pool = new ForkJoinPool();
        MyForkJoinTask task = new MyForkJoinTask(1L, 10_0000_0000L);
        ForkJoinTask<Long> submit = pool.submit(task);
        Long sum = submit.get();

        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + ", elapsed time: " + (end - start));
    }

    public static void test3() {
        long start = System.currentTimeMillis();

        long sum = LongStream.rangeClosed(1L, 10_0000_0000L).parallel().reduce(0, Long::sum);

        long end = System.currentTimeMillis();
        System.out.println("sum=" + sum + ", elapsed time: " + (end - start));
    }
}
