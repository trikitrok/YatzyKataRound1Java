package com.dodevjutsu.kata.yatzy.infrastructure.scores_archives;

import com.dodevjutsu.kata.yatzy.core.Category;
import com.dodevjutsu.kata.yatzy.core.Score;
import com.dodevjutsu.kata.yatzy.core.ScoresArchive;

import java.util.HashMap;
import java.util.Map;

public class InMemoryScoresArchive implements ScoresArchive {
    Map<Category, Score> scoresByCategory = new HashMap<>();

    @Override
    public void register(Score score) {
        scoresByCategory.put(score.category(), score);
    }

    @Override
    public Score retrieve(Category category) {
        return scoresByCategory.get(category);
    }

    @Override
    public int totalScore() {
        return scoresByCategory.values()
            .stream()
            .mapToInt(score -> score.value())
            .reduce(0, (a, b) -> a + b);
    }
}
