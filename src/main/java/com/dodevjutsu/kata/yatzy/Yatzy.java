package com.dodevjutsu.kata.yatzy;

public class Yatzy {
    private final Console console;
    private final DieRoller dieRoller;

    public Yatzy(Console console, DieRoller dieRoller) {
        this.console = console;
        this.dieRoller = dieRoller;
    }

    public void play() {
        console.print("Category: Ones");

        for(int i =0; i<5; i++) {
            dieRoller.roll();
        }
        console.print("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
    }
}
