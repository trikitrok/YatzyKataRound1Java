package com.dodevjutsu.kata.yatzy.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DiceRoller {
    private final DieRoller dieRoller;

    public DiceRoller(DieRoller dieRoller) {
        this.dieRoller = dieRoller;
    }

    public Dice rollAll() {
        List<Side> sides = new ArrayList<>();
        for (int i = 0; i < Dice.NUMBER; i++) {
            sides.add(dieRoller.roll());
        }
        return new Dice(sides);
    }

    public Dice roll(Dice dice, List<Integer> diceToRerunIndexes) {
        Side[] sides = dice.values().toArray(new Side[0]);
        for (int i = 0; i < diceToRerunIndexes.size(); i++) {
            sides[diceToRerunIndexes.get(i)] = dieRoller.roll();
        }
        return new Dice(Arrays.asList(sides));
    }
}

