package com.dodevjutsu.kata.yatzy;

public class Dice {
    private final DieRoller dieRoller;

    public Dice(DieRoller dieRoller) {
        this.dieRoller = dieRoller;
    }

    String lastRolls() {
        String diceLine = "Dice: ";
        for (int i = 0; i < 5; i++) {
            diceLine += "D" + (i + 1) + ":" + dieRoller.roll().toString() + " ";
        }
        return diceLine.trim();
    }
}
