package com.dodevjutsu.kata.yatzy;

import java.util.List;

import static com.dodevjutsu.kata.yatzy.Category.Ones;

public class Yatzy {
    private final InputReader inputReader;
    private final DiceRoller diceRoller;
    private final Notifier notifier;

    public Yatzy(DieRoller dieRoller, Notifier notifier, InputReader inputReader) {
        this.inputReader = inputReader;
        this.diceRoller = new DiceRoller(dieRoller);
        this.notifier = notifier;
    }

    public void play() {
        notifier.notifyCategory(Ones);
        Dice dice = diceRoller.rollAll();
        notifier.notifyCurrentDice(dice);
        notifier.askForDiceToReroll();

        List<Integer> diceToRerun = inputReader.diceToReroll();
        dice = diceRoller.roll(dice, diceToRerun);
        notifier.notifyCurrentDice(dice);
    }
}
