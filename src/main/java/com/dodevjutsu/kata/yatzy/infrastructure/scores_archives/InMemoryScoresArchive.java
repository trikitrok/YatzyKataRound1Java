package com.dodevjutsu.kata.yatzy.infrastructure.scores_archives;

import com.dodevjutsu.kata.yatzy.core.Category;
import com.dodevjutsu.kata.yatzy.core.ScoresArchive;

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

    @Override
    public int totalScore() {
        return scoresByCategory.values()
            .stream()
            .reduce(0, (a, b) -> a + b);
    }
}