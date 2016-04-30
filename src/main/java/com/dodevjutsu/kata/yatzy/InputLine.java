package com.dodevjutsu.kata.yatzy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InputLine {
    private final String content;

    public InputLine(String content) {
        this.content = content;
    }

    public List<Integer> extractDiceNumbers() {
        List<Integer> diceNumbers = new ArrayList<>();

        String[] tokens = content.split(" ");

        for(int i=0; i<tokens.length; i++) {
            Integer diceNumber = Integer.parseInt(tokens[i].substring(1)) - 1;
            diceNumbers.add(diceNumber);
        }

        return diceNumbers;
    }
}
