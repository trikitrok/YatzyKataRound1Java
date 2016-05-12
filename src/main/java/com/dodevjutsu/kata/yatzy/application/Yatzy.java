package com.dodevjutsu.kata.yatzy.application;

import com.dodevjutsu.kata.yatzy.core.*;

import java.util.Arrays;
import java.util.List;

import static com.dodevjutsu.kata.yatzy.core.Category.*;

public class Yatzy {
    private static final int NUMBER_OF_RERUNS = 2;
    private final Notifier notifier;
    private final DiceReruns diceReruns;
    private final ScoresArchive scoresArchive;
    private List<Category> categories = Arrays.asList(Ones, Twos, Threes);
    private DieRoller dieRoller;

    public Yatzy(DieRoller dieRoller, Notifier notifier, InputReader inputReader, ScoresArchive scoresArchive) {
        this.dieRoller = dieRoller;
        this.notifier = notifier;
        this.diceReruns = new DiceReruns(NUMBER_OF_RERUNS, dieRoller, notifier, inputReader);
        this.scoresArchive = scoresArchive;
    }

    public void play() {
        playCategories();
        summarizeGame();
    }

    private void summarizeGame() {
        notifier.notifyGameSummary(new GameSummary(categories, scoresArchive));
    }

    private void playCategories() {
        categories.forEach(this::playCategory);
    }

    private void playCategory(Category category) {
        notifier.notifyCategory(category);
        Dice dice = Dice.rollAll(dieRoller);
        notifier.notifyCurrentDice(dice);
        dice = diceReruns.doReRuns(dice);
        Score score = category.scoreFor(dice);
        notifier.notifyCategoryScore(score);
        scoresArchive.register(score);
    }
}
