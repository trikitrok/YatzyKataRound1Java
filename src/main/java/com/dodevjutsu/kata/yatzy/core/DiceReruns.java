package com.dodevjutsu.kata.yatzy.core;

import java.util.ArrayList;
import java.util.List;

public class DiceReruns {
    List<DiceRerun> diceReruns = new ArrayList<>();

    public DiceReruns(int numberOfReruns, DiceRoller diceRoller, Notifier notifier, InputReader inputReader) {
        for (int i = 1; i <= numberOfReruns; i++) {
            diceReruns.add(new DiceRerun(i, diceRoller, notifier, inputReader));
        }
    }

    public Dice doReRuns(Dice dice) {
        for (DiceRerun diceRerun : diceReruns) {
            dice = diceRerun.doRerun(dice);
        }
        return dice;
    }
}
