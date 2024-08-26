package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("masha.maria.vas@bk.ru", "Maria Vasileva");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
