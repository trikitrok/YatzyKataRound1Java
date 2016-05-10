package com.dodevjutsu.kata.yatzy.infrastructure.input_readers;

import com.dodevjutsu.kata.yatzy.core.InputReader;
import com.dodevjutsu.kata.yatzy.infrastructure.Console;

import java.util.List;

public class ConsoleInputReader implements InputReader {
    private final Console console;

    public ConsoleInputReader(Console console) {
        this.console = console;
    }

    public List<Integer> diceToRerun() {
        String line = console.readLine();
        return new InputLine(line).extractDiceIndexes();
    }
}
