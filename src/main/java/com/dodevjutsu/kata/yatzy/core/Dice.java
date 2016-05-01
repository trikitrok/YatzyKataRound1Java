package com.dodevjutsu.kata.yatzy.core;

import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;

public class Dice {
    public static final int NUMBER = 5;
    List<Side> values;

    public Dice(List<Side> values) {
        this.values = values;
    }

    public String lastRolls() {
        return IntStream.range(0, values.size())
            .mapToObj(i -> String.format("D%d:%s ", i + 1, values.get(i)))
            .reduce("Dice: ", (a, b) -> a + b)
            .trim();
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
