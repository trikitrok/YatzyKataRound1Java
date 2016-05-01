package com.dodevjutsu.kata.yatzy;

import java.util.Arrays;
import java.util.List;

import static com.dodevjutsu.kata.yatzy.Category.*;
import static com.dodevjutsu.kata.yatzy.Category.Ones;

public class Yatzy {
    private static final int NUMBER_OF_RERUNS = 2;
    private final InputReader inputReader;
    private final DiceRoller diceRoller;
    private final Notifier notifier;
    private final DiceReruns diceReruns;
    private List<Category> categories = Arrays.asList(Ones, Twos);

    public Yatzy(DieRoller dieRoller, Notifier notifier, InputReader inputReader) {
        this.inputReader = inputReader;
        this.notifier = notifier;
        this.diceRoller = new DiceRoller(dieRoller);
        this.diceReruns = new DiceReruns(NUMBER_OF_RERUNS, diceRoller, notifier, inputReader);
    }

    public void play() {
        for(Category category : categories) {
            notifier.notifyCategory(category);
            Dice dice = diceRoller.rollAll();
            notifier.notifyCurrentDice(dice);
            dice = diceReruns.doReRuns(dice);
            notifier.notifyCategoryScore(category, category.scoreFor(dice));
        }
    }

}
