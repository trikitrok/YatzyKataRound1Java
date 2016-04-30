package com.dodevjutsu.kata.yatzy;

import java.util.List;

public class ConsoleInputReader implements InputReader {
    private final Console console;
    private final Notifier notifier;

    public ConsoleInputReader(Console console, Notifier notifier) {
        this.console = console;
        this.notifier = notifier;
    }

    public List<Integer> diceToReroll() {
        String line = console.readLine();
        notifier.notifyUserInput(line);
        return new InputLine(line).extractDiceIndexes();
    }
}
