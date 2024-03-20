package ru.job4j.oop;

public class BallStory {
    public static void main(String[] args) {
        Ball kolobok = new Ball();
        Hare hare = new Hare();
        hare.tryEat(kolobok);
        Wolf wolf = new Wolf();
        wolf.tryEat(kolobok);
        Fox fox = new Fox();
        fox.tryEat(kolobok);
    }
}
