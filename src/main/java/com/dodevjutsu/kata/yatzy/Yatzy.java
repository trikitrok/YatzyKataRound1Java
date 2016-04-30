package com.dodevjutsu.kata.yatzy;

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

        for(int i=1; i<=2; i++) {
            dice = doRerun(dice, i);
        }
    }

    private Dice doRerun(Dice dice, int rerunNumber) {
        notifier.askForDiceToRerun(rerunNumber);
        dice = diceRoller.roll(dice, inputReader.diceToRerun());
        notifier.notifyCurrentDice(dice);
        return dice;
    }
}
