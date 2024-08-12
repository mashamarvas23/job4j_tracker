package ru.job4j.ex;

import java.util.Objects;

public class FindMaxLength {
    public static void main(String[] args) {
        String[] shops = {"Ebay", null, "Amazon", null, "Ozon"};
        int max = 0;
        for (int index = 0; index < shops.length; index++) {
            String element = shops[index];
            if (Objects.nonNull(element)) {
                if (element.length() > max) {
                    max = element.length();
                }
            }
        }
        System.out.println("Max length : " + max);
    }
}
