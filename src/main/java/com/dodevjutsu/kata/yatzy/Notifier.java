package com.dodevjutsu.kata.yatzy;

public interface Notifier {
    void notifyCategory(Category category);

    void notifyCurrentDice(Dice dice);

    void askForDiceToReroll(int rerollNumber);

    void notifyUserInput(String input);
}
