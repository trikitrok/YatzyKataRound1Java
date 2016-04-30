package com.dodevjutsu.kata.yatzy;

import java.util.ArrayList;
import java.util.List;

public class Dice {
    private final DieRoller dieRoller;
    List<Side> sides;

    public Dice(List<Side> sides) {
        this.sides = sides;
        dieRoller = null;
    }

    String lastRolls() {
        String diceLine = "Dice: ";
        for (int i = 0; i < sides.size(); i++) {
            diceLine += "D" + (i + 1) + ":" + sides.get(i) + " ";
        }
        return diceLine.trim();
    }
}
