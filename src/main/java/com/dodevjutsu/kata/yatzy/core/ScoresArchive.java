package com.dodevjutsu.kata.yatzy.core;

public interface ScoresArchive {
    void register(Score score);

    Score retrieve(Category category);

    int totalScore();
}
