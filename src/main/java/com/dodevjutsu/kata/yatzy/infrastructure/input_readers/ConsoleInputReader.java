package com.dodevjutsu.kata.yatzy.infrastructure.input_readers;

import com.dodevjutsu.kata.yatzy.core.InputReader;
import com.dodevjutsu.kata.yatzy.core.Notifier;
import com.dodevjutsu.kata.yatzy.infrastructure.Console;

import java.util.List;

public class ConsoleInputReader implements InputReader {
    private final Console console;
    private Notifier notifier;

    public ConsoleInputReader(Console console, Notifier notifier) {
        this.console = console;
        this.notifier = notifier;
    }

    public List<Integer> diceToRerun(int rerunNumber) {
        notifier.askForDiceToRerun(requestPhrase(rerunNumber));
        return getDiceToRerun(rerunNumber);
    }

    private List<Integer> getDiceToRerun(int rerunNumber) {
        List<Integer> diceToRerun;
        String line = console.readLine();
        try {
            diceToRerun = new InputLine(line).extractDiceIndexes();
        } catch(WrongInputException e) {
            notifier.notifyInputError(e.getMessage());
            diceToRerun = diceToRerun(rerunNumber);
        }
        return diceToRerun;
    }

    public String requestPhrase(int rerunNumber) {
        return "[" + rerunNumber + "] Dice to re-run:";
    }
}
