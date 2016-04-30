package com.dodevjutsu.kata.yatzy;

public class Yatzy {
    private final Console console;
    private final DieRoller dieRoller;
    private final Dice dice;

    public Yatzy(Console console, DieRoller dieRoller) {
        this.console = console;
        this.dieRoller = dieRoller;
        this.dice = new Dice(dieRoller);
    }

    public void play() {
        console.print("Category: Ones");
        dice.roll();
        console.print(dice.lastRolls());
    }
}
