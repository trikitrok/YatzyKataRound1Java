package com.dodevjutsu.kata.yatzy;

public interface ScoresArchive {
    void register(Category category, int score);

    int retrieve(Category category);
}
