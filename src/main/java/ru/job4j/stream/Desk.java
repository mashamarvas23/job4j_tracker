package ru.job4j.stream;

import java.util.stream.Stream;

public class Desk {
    public static void main(String[] args) {
        Stream.of(Value.values())
                .flatMap(value -> Stream.of(Suit.values())
                        .map(suit -> new Card(suit, value)))
                .forEach(System.out::println);
    }
}
