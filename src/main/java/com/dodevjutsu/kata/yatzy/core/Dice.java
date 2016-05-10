package com.dodevjutsu.kata.yatzy.core;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Dice {
    private static final int NUMBER = 5;
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

    public int countWithSide(Side side) {
        return (int) values.stream()
            .filter(s -> s.equals(side))
            .count();
    }

    public static Dice rollAll(DieRoller dieRoller) {
        List<Side> sides = new ArrayList<>();
        for (int i = 0; i < Dice.NUMBER; i++) {
            sides.add(dieRoller.roll());
        }
        return new Dice(sides);
    }

    public Dice roll(List<Integer> diceToRerunIndexes, DieRoller dieRoller) {
        List<Side> sides = new ArrayList<>(values);
        for (Integer index : diceToRerunIndexes) {
            sides.set(index, dieRoller.roll());
        }
        return new Dice(sides);
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
