package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    public void put(Task task) {
        int index = 0;
        if (tasks.isEmpty()) {
            tasks.add(task);
        }
        for (Task element : tasks) {
            if (task.getPriority() < element.getPriority()) {
                this.tasks.add(index, task);
                break;
            }
            index++;
        }
    }

    public Task take() {
        return tasks.poll();
    }
}
