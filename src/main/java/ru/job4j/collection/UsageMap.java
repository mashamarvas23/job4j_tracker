package ru.job4j.collection;

import java.util.HashMap;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("masha.maria.vas@bk.ru", "Maria Vasileva");
        map.put("stas_mikhailov@bk.ru", "Stas Mikhailov");
        map.put("dominik_joker@bk.ru", "Dominik Joker");
        map.put("timati@bk.ru", "Timati");
        map.put("timati@bk.ru", "Timati Ivanov");
        for (String key : map.keySet()) {
            System.out.println(map.get(key));
        }
    }
}
