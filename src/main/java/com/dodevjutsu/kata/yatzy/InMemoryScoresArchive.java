package com.dodevjutsu.kata.yatzy;

import java.util.HashMap;
import java.util.Map;

public class InMemoryScoresArchive implements ScoresArchive {
    Map<Category, Integer> scoresByCategory = new HashMap<>();

    @Override
    public void register(Category category, int score) {
        scoresByCategory.put(category, score);
    }

    @Override
    public int retrieve(Category category) {
        return scoresByCategory.get(category);
    }
}
