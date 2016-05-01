package com.dodevjutsu.kata.yatzy;

import java.util.List;

public interface Notifier {
    void notifyCategory(Category category);

    void notifyCurrentDice(Dice dice);

    void notifyUserInput(String input);

    void notifyCategoryScore(Category category, int score);

    void askForDiceToRerun(DiceRerun diceRerun);

    void notifyGameSummary(List<Category> categories, ScoresArchive scoresArchive);
}
