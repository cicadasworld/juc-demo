package com.cicadasworld.forkjoin;

import java.util.concurrent.RecursiveTask;

/**
 * 求和计算
 */
public class MyForkJoinTask extends RecursiveTask<Long> {

    private Long start;
    private Long end;

    private Long temp = 1000000L;

    public MyForkJoinTask(Long start, Long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        if ((end - start) < temp) {
            Long sum = 0L;
            for (Long i = start; i <= end; i++) {
                sum += i;
            }
            return sum;
        } else {
            Long middle = (start + end) / 2;
            MyForkJoinTask task1 = new MyForkJoinTask(start, middle);
            task1.fork();
            MyForkJoinTask task2 = new MyForkJoinTask(middle + 1, end);
            task2.fork();
            return task1.join() + task2.join();
        }
    }
}
