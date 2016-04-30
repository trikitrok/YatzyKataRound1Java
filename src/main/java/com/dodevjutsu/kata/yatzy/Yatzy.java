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

        String diceLine = "Dice: ";
        for (int i = 0; i < 5; i++) {
            diceLine += "D" + (i + 1) + ":" + dieRoller.roll().toString() + " ";
        }
        console.print(diceLine.trim());
    }
}
