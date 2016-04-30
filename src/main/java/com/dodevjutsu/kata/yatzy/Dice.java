package com.dodevjutsu.kata.yatzy;

import java.util.Collections;
import java.util.List;

public class Dice {
    List<Side> sides;

    public Dice(List<Side> sides) {
        this.sides = sides;
    }

    String lastRolls() {
        String diceLine = "Dice: ";
        for (int i = 0; i < sides.size(); i++) {
            diceLine += "D" + (i + 1) + ":" + sides.get(i) + " ";
        }
        return diceLine.trim();
    }

    @Override
    public String toString() {
        return "Dice{" +
            "sides=" + sides +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dice)) return false;

        Dice dice = (Dice) o;

        return sides != null ? sides.equals(dice.sides) : dice.sides == null;

    }

    @Override
    public int hashCode() {
        return sides != null ? sides.hashCode() : 0;
    }

    public List<Side> sides() {
        return Collections.unmodifiableList(sides);
    }
}
