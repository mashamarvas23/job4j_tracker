package ru.job4j.tracker;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class SortItemTest {

    @Test
    void sortAscByName() {
        List<Item> items = Arrays.asList(
                new Item("Николай", 10),
                new Item("Василий", 7),
                new Item("Алена", 5),
                new Item("Ярослав", 12));
        ItemAscByName comparator = new ItemAscByName();
        items.sort(comparator);
        List<Item> expected = Arrays.asList(
                new Item("Алена", 5),
                new Item("Василий", 7),
                new Item("Николай", 10),
                new Item("Ярослав", 12));
        assertThat(expected).isEqualTo(items);
    }

    @Test
    void sortDescByName() {
        List<Item> items = Arrays.asList(
                new Item("Николай"),
                new Item("Василий"),
                new Item("Алена"),
                new Item("Ярослав"));
        ItemDescByName comparator = new ItemDescByName();
        items.sort(comparator);
        List<Item> expected = Arrays.asList(
                new Item("Ярослав"),
                new Item("Николай"),
                new Item("Василий"),
                new Item("Алена"));
        assertThat(expected).isEqualTo(items);
    }
}
