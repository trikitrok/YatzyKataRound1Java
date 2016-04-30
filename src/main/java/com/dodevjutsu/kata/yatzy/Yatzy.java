package com.dodevjutsu.kata.yatzy;

public class Yatzy {
    private final Console console;
    private final DiceRoller diceRoller;

    public Yatzy(Console console, DiceRoller diceRoller) {
        this.console = console;
        this.diceRoller = diceRoller;
    }

    public void play() {
        console.print("Category: Ones");
        Dice dice = diceRoller.roll();
        console.print(dice.lastRolls());
    }
}
