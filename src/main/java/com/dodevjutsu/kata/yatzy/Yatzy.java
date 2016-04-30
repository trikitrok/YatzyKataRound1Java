package com.dodevjutsu.kata.yatzy;

public class Yatzy {
    private final Console console;
    private final DiceRoller diceRoller;

    public Yatzy(Console console, DieRoller dieRoller) {
        this.console = console;
        this.diceRoller = new DiceRoller(dieRoller);
    }

    public void play() {
        console.print("Category: Ones");
        Dice dice = diceRoller.roll();
        console.print(dice.lastRolls());
    }
}
