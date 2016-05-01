package com.dodevjutsu.kata.yatzy.infrastructure.input_readers;

import com.dodevjutsu.kata.yatzy.infrastructure.Console;
import com.dodevjutsu.kata.yatzy.core.InputReader;
import com.dodevjutsu.kata.yatzy.core.Notifier;

import java.util.List;

public class ConsoleInputReader implements InputReader {
    private final Console console;
    private final Notifier notifier;

    public ConsoleInputReader(Console console, Notifier notifier) {
        this.console = console;
        this.notifier = notifier;
    }

    public List<Integer> diceToRerun() {
        String line = console.readLine();
        notifier.notifyUserInput(line);
        return new InputLine(line).extractDiceIndexes();
    }
}
