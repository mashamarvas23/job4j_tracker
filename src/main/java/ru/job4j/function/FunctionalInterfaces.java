package ru.job4j.function;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.*;

public class FunctionalInterfaces {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        BiConsumer<Integer, String> biConsumer = (key, value) -> map.put(key, value);
        BiPredicate<Integer, String> biPredicate = (key, value) -> (key % 2 == 0 || map.get(key).length() == 4);
        Supplier<List<String>> supplier = () -> new ArrayList<>(map.values());
        Consumer<String> consumer = (string) -> System.out.println(string);
        Function<String, String> function = (string) -> string.toUpperCase();
    }
}