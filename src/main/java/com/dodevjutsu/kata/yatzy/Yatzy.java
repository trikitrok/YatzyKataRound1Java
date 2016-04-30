package com.dodevjutsu.kata.yatzy;

public class Yatzy {
    private final Console console;

    public Yatzy(Console console) {
        this.console = console;
    }

    public void play() {
        console.print("Category: Ones");
        console.print("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
    }
}
