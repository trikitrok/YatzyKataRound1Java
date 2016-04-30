package com.dodevjutsu.kata.yatzy;

import java.util.ArrayList;
import java.util.List;

public class DiceRoller {
    private final DieRoller dieRoller;

    public DiceRoller(DieRoller dieRoller) {
        this.dieRoller = dieRoller;
    }

    public Dice roll() {
        List<Side> sides = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sides.add(dieRoller.roll());
        }
        return new Dice(sides);
    }
}

