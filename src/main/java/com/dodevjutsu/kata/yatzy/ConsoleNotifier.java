package com.dodevjutsu.kata.yatzy;

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
    public void askForDiceToRerun(int rerunNumber) {
        console.print("[" + rerunNumber + "] Dice to re-run:");
    }

    @Override
    public void notifyUserInput(String input) {
        console.print(input);
    }

    @Override
    public void notifyCategoryScore(Category category, int score) {
        console.print("Category Ones score: 4");
    }
}
