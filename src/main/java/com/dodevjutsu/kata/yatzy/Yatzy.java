package com.dodevjutsu.kata.yatzy;

public class Yatzy {
    private final Console console;
    private final UserInput userInput;
    private final DiceRoller diceRoller;

    public Yatzy(Console console, UserInput userInput, DiceRoller diceRoller) {
        this.console = console;
        this.userInput = userInput;
        this.diceRoller = diceRoller;
    }

    public void play() {
        console.print("Category: Ones");
        Dice dice = diceRoller.roll();
        console.print(dice.lastRolls());
        console.print("[1] Dice to re-run:");
        console.print(userInput.read());
    }
}
