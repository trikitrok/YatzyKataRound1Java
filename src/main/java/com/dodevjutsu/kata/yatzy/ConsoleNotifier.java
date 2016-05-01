package com.dodevjutsu.kata.yatzy;

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
    public void notifyUserInput(String input) {
        console.print(input);
    }

    @Override
    public void notifyCategoryScore(Category category, int score) {
        console.print(category.scoreAsString(score));
    }

    @Override
    public void askForDiceToRerun(DiceRerun diceRerun) {
        console.print(diceRerun.requestPhrase());
    }

    @Override
    public void notifyGameSummary(List<Category> categories, ScoresArchive scoresArchive) {
        console.print("Yahtzee score");
        for(Category category: categories) {
            console.print(category.name() + ": " + scoresArchive.retrieve(category));
        }
        console.print("Final score: " + scoresArchive.totalScore());
    }
}
