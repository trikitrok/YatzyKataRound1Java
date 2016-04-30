package com.dodevjutsu.kata.yatzy;

import java.util.List;

import static com.dodevjutsu.kata.yatzy.Category.Ones;

public class Yatzy {
    private final Console console;
    private final UserInput userInput;
    private final DiceRoller diceRoller;
    private final Notifier notifier;

    public Yatzy(Console console, UserInput userInput, DieRoller dieRoller, Notifier notifier) {
        this.console = console;
        this.userInput = userInput;
        this.diceRoller = new DiceRoller(dieRoller);
        this.notifier = notifier;
    }

    public void play() {
        notifier.notifyCategory(Ones);
        Dice dice = diceRoller.rollAll();
        notifier.notifyCurrentDice(dice);
        notifier.askForDiceToReroll();

        String userInputLine = userInput.read();
        console.print(userInputLine);

        List<Integer> diceToRerun = new InputLine(userInputLine).extractDiceIndexes();
        dice = diceRoller.roll(dice, diceToRerun);
        notifier.notifyCurrentDice(dice);
    }
}
