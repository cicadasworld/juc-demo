package com.cicadasworld.functioninterface;

import java.util.function.Consumer;

/**
 * 消费型接口
 */
public class ConsumerTest {

    public static void main(String[] args) {
//        Consumer<String> consumer = new Consumer<String>() {
//            @Override
//            public void accept(String text) {
//                System.out.println(text);
//            }
//        };

        Consumer<String> consumer = text -> System.out.println(text);

        consumer.accept("Hello, Consumer");
    }
}
