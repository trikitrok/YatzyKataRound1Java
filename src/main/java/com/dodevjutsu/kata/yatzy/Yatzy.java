package com.dodevjutsu.kata.yatzy;

import java.util.List;

import static com.dodevjutsu.kata.yatzy.Category.Ones;

public class Yatzy {
    private final Console console;
    private final DiceRoller diceRoller;
    private final Notifier notifier;

    public Yatzy(Console console, DieRoller dieRoller, Notifier notifier) {
        this.console = console;
        this.diceRoller = new DiceRoller(dieRoller);
        this.notifier = notifier;
    }

    public void play() {
        notifier.notifyCategory(Ones);
        Dice dice = diceRoller.rollAll();
        notifier.notifyCurrentDice(dice);
        notifier.askForDiceToReroll();

        String line = console.readLine();
        console.print(line);

        List<Integer> diceToRerun = new InputLine(line).extractDiceIndexes();
        dice = diceRoller.roll(dice, diceToRerun);
        notifier.notifyCurrentDice(dice);
    }
}
