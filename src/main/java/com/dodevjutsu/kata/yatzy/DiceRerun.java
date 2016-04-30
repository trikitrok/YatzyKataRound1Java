package com.dodevjutsu.kata.yatzy;

public class DiceRerun {
    private final int rerunNumber;
    private final Notifier notifier;
    private final InputReader inputReader;
    private final DiceRoller diceRoller;

    public DiceRerun(int rerunNumber, DiceRoller diceRoller, Notifier notifier, InputReader inputReader) {
        this.rerunNumber = rerunNumber;
        this.diceRoller = diceRoller;
        this.notifier = notifier;
        this.inputReader = inputReader;
    }

    public Dice doRerun(Dice dice) {
        notifier.askForDiceToRerun(rerunNumber);
        dice = diceRoller.roll(dice, inputReader.diceToRerun());
        notifier.notifyCurrentDice(dice);
       return dice;
    }
}
