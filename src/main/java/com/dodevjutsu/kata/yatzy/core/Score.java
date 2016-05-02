package com.dodevjutsu.kata.yatzy.core;

public class Score {
    private final Category category;
    private final int value;

    public Score(Category category, int value) {
        this.category = category;
        this.value = value;
    }

    public Category category() {
        return category;
    }

    public int value() {
        return value;
    }

    public String description() {
        return "Category " + category.name() + " score: " + value;
    }

    public String summaryDescription() {
        return category.name() + ": " + value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Score)) return false;

        Score score = (Score) o;

        if (value != score.value) return false;
        return category == score.category;

    }

    @Override
    public int hashCode() {
        int result = category != null ? category.hashCode() : 0;
        result = 31 * result + value;
        return result;
    }
}
