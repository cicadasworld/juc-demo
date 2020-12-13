package com.cicadasworld.stream;

import java.util.stream.Stream;

public class StreamTest {

    public static void main(String[] args) {
        User u1 = new User(1, "a", 21);
        User u2 = new User(2, "b", 22);
        User u3 = new User(3, "c", 23);
        User u4 = new User(4, "d", 24);
        User u5 = new User(5, "e", 25);
        User u6 = new User(6, "f", 26);

        Stream.of(u1, u2, u3, u4, u5)
                .filter(u -> u.getId() % 2 == 0)
                .filter(u -> u.getAge() > 23)
                .map(u -> u.getName().toUpperCase())
                .sorted((c1, c2) -> c2.compareTo(c1))
                .limit(1)
                .forEach(System.out::println);
    }
}
