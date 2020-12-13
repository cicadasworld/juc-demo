package com.cicadasworld.singleton;

// 饿汉式
public class HungrySingleton {

//    private byte[] data1 = new byte[1024 * 1024];
//    private byte[] data2 = new byte[1024 * 1024];
//    private byte[] data3 = new byte[1024 * 1024];
//    private byte[] data4 = new byte[1024 * 1024];

    private final static HungrySingleton INSTANCE = new HungrySingleton();

    private HungrySingleton() {}

    public static HungrySingleton getInstance() {
        return INSTANCE;
    }
}
