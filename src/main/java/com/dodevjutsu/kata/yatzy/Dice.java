package com.dodevjutsu.kata.yatzy;

import java.util.Collections;
import java.util.List;

public class Dice {
    public static final int NUMBER = 5;
    List<Side> values;

    public Dice(List<Side> values) {
        this.values = values;
    }

    String lastRolls() {
        String diceLine = "Dice: ";
        for (int i = 0; i < values.size(); i++) {
            diceLine += "D" + (i + 1) + ":" + values.get(i) + " ";
        }


        return diceLine.trim();
    }

    public List<Side> values() {
        return Collections.unmodifiableList(values);
    }

    public int countWithSide(Side side) {
        return (int) values.stream()
            .filter(s -> s.equals(side))
            .count();
    }

    @Override
    public String toString() {
        return "Dice{" +
            "values=" + values +
            '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dice)) return false;

        Dice dice = (Dice) o;

        return values != null ? values.equals(dice.values) : dice.values == null;
    }

    @Override
    public int hashCode() {
        return values != null ? values.hashCode() : 0;
    }
}
