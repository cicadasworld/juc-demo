package com.cicadasworld.singleton;

public class StaticInnerClassSingleton {

    private StaticInnerClassSingleton() {}

    private static class StaticInnerClassSingletonHolder {
        private static final StaticInnerClassSingleton INSTANCE = new StaticInnerClassSingleton();
    }

    public static StaticInnerClassSingleton getInstance() {
        return StaticInnerClassSingletonHolder.INSTANCE;
    }
}
