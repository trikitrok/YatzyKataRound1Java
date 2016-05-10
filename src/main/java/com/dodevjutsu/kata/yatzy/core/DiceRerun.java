package com.dodevjutsu.kata.yatzy.core;

public class DiceRerun {
    private final int rerunNumber;
    private final Notifier notifier;
    private final InputReader inputReader;
    private final DieRoller dieRoller;

    public DiceRerun(int rerunNumber, DieRoller dieRoller, Notifier notifier, InputReader inputReader) {
        this.rerunNumber = rerunNumber;
        this.dieRoller = dieRoller;
        this.notifier = notifier;
        this.inputReader = inputReader;
    }

    public Dice doRerun(Dice dice) {
        notifier.askForDiceToRerun(this);
        dice = dice.roll(inputReader.diceToRerun(), dieRoller);
        notifier.notifyCurrentDice(dice);
        return dice;
    }

    public String requestPhrase() {
        return "[" + rerunNumber + "] Dice to re-run:";
    }
}
