package com.dodevjutsu.kata.yatzy;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class InputLine {
    private final String content;

    public InputLine(String content) {
        this.content = content;
    }

    public List<Integer> extractDiceIndexes() {
        String[] tokens = content.split(" ");
        return Stream.of(tokens)
            .map(this::toDiceNumber)
            .map(this::toDiceIndex)
            .collect(Collectors.toList());
    }

    private int toDiceIndex(Integer diceNumber) {
        return diceNumber - 1;
    }

    private int toDiceNumber(String token) {
        return Integer.parseInt(token.substring(1));
    }
}
