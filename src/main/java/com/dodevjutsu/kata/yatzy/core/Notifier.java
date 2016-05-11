package com.dodevjutsu.kata.yatzy.core;

public interface Notifier {
    void notifyCategory(Category category);

    void notifyCurrentDice(Dice dice);

    void notifyCategoryScore(Score score);

    void askForDiceToRerun(String rerunRequest);

    void notifyGameSummary(GameSummary gameSummary);

    void notifyInputError(String errorMessage);
}
