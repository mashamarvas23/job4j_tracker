package ru.job4j.queue;

import java.util.Deque;

public class ReconstructPhrase {

    private final Deque<Character> descendingElements;

    private final Deque<Character> evenElements;

    public ReconstructPhrase(Deque<Character> descendingElements, Deque<Character> evenElements) {
        this.descendingElements = descendingElements;
        this.evenElements = evenElements;
    }

    private String getEvenElements() {
        Character tmp;
        StringBuilder builder = new StringBuilder();
        int size = evenElements.size();
        for (int i = 0; i < size; i++) {
            tmp = evenElements.poll();
            if (i % 2 == 0) {
                builder.append(tmp);
            }
        }
        return builder.toString();
    }

    private String getDescendingElements() {
        StringBuilder builder = new StringBuilder();
        for (int i = descendingElements.size() - 1; i >= 0; i--) {
            builder.append(descendingElements.pollLast());
        }
        return builder.toString();
    }

    public String getReconstructPhrase() {
        return getEvenElements() + getDescendingElements();
    }
}