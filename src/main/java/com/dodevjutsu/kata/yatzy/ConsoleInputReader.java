package com.dodevjutsu.kata.yatzy;

import java.util.List;

public class ConsoleInputReader implements InputReader {
    private final Console console;

    public ConsoleInputReader(Console console) {
        this.console = console;
    }

    public List<Integer> diceToReroll() {
        String line = console.readLine();
        console.print(line);
        return new InputLine(line).extractDiceIndexes();
    }
}
