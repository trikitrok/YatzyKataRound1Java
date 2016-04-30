package com.dodevjutsu.kata.yatzy;

import java.util.List;

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
        Dice dice = diceRoller.rollAll();
        console.print(dice.lastRolls());
        console.print("[1] Dice to re-run:");

        String userInputLine = userInput.read();
        console.print(userInputLine);

        List<Integer> diceToRerun = new InputLine(userInputLine).extractDiceIndexes();
        dice = diceRoller.roll(dice, diceToRerun);
        console.print(dice.lastRolls());
    }
}
