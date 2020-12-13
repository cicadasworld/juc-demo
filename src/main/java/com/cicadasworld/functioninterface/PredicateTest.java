package com.cicadasworld.functioninterface;

import java.util.function.Predicate;

/**
 * 断定型接口
 */
public class PredicateTest {

    public static void main(String[] args) {
//        Predicate<String> predicate = new Predicate<String>() {
//            @Override
//            public boolean test(String text) {
//                return text.isEmpty();
//            }
//        };

        Predicate<String> predicate = predicate = text -> text.isEmpty();

        System.out.println(predicate.test(""));
    }
}
