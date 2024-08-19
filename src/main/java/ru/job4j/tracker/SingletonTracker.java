package ru.job4j.tracker;

import java.util.List;
import java.util.Objects;

public class SingletonTracker {
    private Tracker tracker = new Tracker();
    private static SingletonTracker instance = null;

    private SingletonTracker() {
    }

    public static SingletonTracker getInstance() {
        if (Objects.isNull(instance)) {
            instance = new SingletonTracker();
        }
        return instance;
    }

    public Item add(Item item) {
        return tracker.add(item);
    }

    public Item findById(int id) {
        return tracker.findById(id);
    }

    public List<Item> findByName(String key) {
        return tracker.findByName(key);
    }

    public List<Item> findAll() {
        return tracker.findAll();
    }

    public boolean replace(int id, Item item) {
        return tracker.replace(id, item);
    }

    public void delete(int id) {
        tracker.delete(id);
    }
}
