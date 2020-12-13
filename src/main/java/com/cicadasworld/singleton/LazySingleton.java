package com.cicadasworld.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

// 懒汉式
public class LazySingleton {

    private static boolean object = false;

    private volatile static LazySingleton instance;

    private LazySingleton() {

        synchronized (LazySingleton.class) {
            if (object == false) {
                object = true;
            } else  {
                throw new RuntimeException("不要试图使用反射破坏异常");
            }
        }

        System.out.println(Thread.currentThread().getName());
    }

    // DCL: double check lock
    public static LazySingleton getInstance() {
        if (instance == null) {
            synchronized (LazySingleton.class) {
                if (instance == null) {
                    instance = new LazySingleton(); // 不是原子性操作
                }
            }
        }
        return instance;
    }

    // 多线程并发
//    public static void main(String[] args) {
//        for (int i = 0; i < 10; i++) {
//            new Thread(() -> {
//                LazySingleton.getInstance();
//            }).start();
//        }
//    }

    public static void main(String[] args) throws Exception {
        LazySingleton instance = LazySingleton.getInstance();
        Constructor<LazySingleton> declaredConstructor = LazySingleton.class.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        LazySingleton instance2 = declaredConstructor.newInstance();
        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());
    }
}
