package com.cicadasworld.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        MyThread thread = new MyThread();
        FutureTask<Integer> futureTask = new FutureTask<>(thread);
        new Thread(futureTask).start();
        Integer i = futureTask.get(); // get方法会产生阻塞， 放到最后一行或使用异步通信
        System.out.println(i);
    }
}

class MyThread implements Callable<Integer> {

    @Override
    public Integer call() {
        System.out.println("call()"); // 会打印几遍，只有一遍，有缓存
        return 1024;
    }
}
