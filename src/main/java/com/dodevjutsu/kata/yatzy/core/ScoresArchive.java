package com.dodevjutsu.kata.yatzy.core;

public interface ScoresArchive {
    void register(Category category, int score);

    int retrieve(Category category);

    int totalScore();
}
