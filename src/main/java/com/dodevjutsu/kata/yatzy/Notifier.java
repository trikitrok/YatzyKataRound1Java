package com.dodevjutsu.kata.yatzy;

public interface Notifier {
    void notifyCategory(Category category);

    void notifyCurrentDice(Dice dice);

    void askForDiceToRerun(int rerunNumber);

    void notifyUserInput(String input);
}
