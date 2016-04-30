package com.dodevjutsu.kata.yatzy;

public class Yatzy {
    private final Console console;

    public Yatzy(Console console) {
        this.console = console;
    }

    public void play() {
        console.print("Category: Ones");
    }
}
