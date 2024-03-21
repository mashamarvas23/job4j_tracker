package ru.job4j.oop;

public class Story {
    public static void main(String[] args) {
        Pioneer petya = new Pioneer();
        Wolf wolf = new Wolf();
        Girl oksana = new Girl();
        oksana.help(petya);
        wolf.eat(oksana);
        petya.kill(wolf);
    }
}
