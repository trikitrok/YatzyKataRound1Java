package com.dodevjutsu.kata.yatzy.core;

import java.util.List;
import java.util.stream.Collectors;

public class GameSummary {
    private final List<Category> categories;
    private final ScoresArchive scoresArchive;

    public GameSummary(List<Category> categories, ScoresArchive scoresArchive) {
        this.categories = categories;
        this.scoresArchive = scoresArchive;
    }

    public String header() {
        return "Yahtzee score";
    }

    public List<String> scoresSummaryDescriptions() {
        return categories.stream()
            .map(category -> scoresArchive.retrieve(category))
            .map(score -> score.summaryDescription())
            .collect(Collectors.toList());
    }

    public String finalScore() {
        return "Final score: " + scoresArchive.totalScore();
    }
}
