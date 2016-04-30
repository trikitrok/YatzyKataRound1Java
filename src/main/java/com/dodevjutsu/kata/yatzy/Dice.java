package com.dodevjutsu.kata.yatzy;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    private final DieRoller dieRoller;
    List<Side> sides;

    public Dice(DieRoller dieRoller) {
        this.dieRoller = dieRoller;
    }

    public void roll() {
        sides = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            sides.add(dieRoller.roll());
        }
    }

    String lastRolls() {
        String diceLine = "Dice: ";
        for (int i = 0; i < sides.size(); i++) {
            diceLine += "D" + (i + 1) + ":" + sides.get(i) + " ";
        }
        return diceLine.trim();
    }
}
