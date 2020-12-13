package com.cicadasworld.functioninterface;

import java.util.function.Function;

/**
 * java.util.Function 函数型接口
 */
public class FunctionTest {

    public static void main(String[] args) {
//        Function<String, String> function = new Function<String, String>() {
//            @Override
//            public String apply(String text) {
//                return text;
//            }
//        };

        Function<String, String> function = text -> text;

        System.out.println(function.apply("hello, Function Interface"));
    }
}
