package com.dodevjutsu.kata.yatzy.infrastructure.notifiers;

import com.dodevjutsu.kata.yatzy.core.*;
import com.dodevjutsu.kata.yatzy.infrastructure.Console;

import java.util.List;

public class ConsoleNotifier implements Notifier {
    private final Console console;

    public ConsoleNotifier(Console console) {
        this.console = console;
    }

    public void notifyCategory(Category category) {
        console.print(category.toString());
    }

    @Override
    public void notifyCurrentDice(Dice dice) {
        console.print(dice.lastRolls());
    }

    @Override
    public void notifyCategoryScore(Score score) {
        console.print(score.description());
    }

    @Override
    public void askForDiceToRerun(DiceRerun diceRerun) {
        console.print(diceRerun.requestPhrase());
    }

    @Override
    public void notifyGameSummary(GameSummary gameSummary) {
        console.print(gameSummary.header());
        List<String> scores = gameSummary.scoresSummaryDescriptions();
        scores.forEach(console::print);
        console.print(gameSummary.finalScore());
    }
}
