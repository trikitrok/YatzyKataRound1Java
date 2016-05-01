package com.dodevjutsu.kata.yatzy.application;

import com.dodevjutsu.kata.yatzy.core.*;
import com.dodevjutsu.kata.yatzy.infrastructure.DieRoller;

import java.util.Arrays;
import java.util.List;

import static com.dodevjutsu.kata.yatzy.core.Category.*;

public class Yatzy {
    private static final int NUMBER_OF_RERUNS = 2;
    private final DiceRoller diceRoller;
    private final Notifier notifier;
    private final DiceReruns diceReruns;
    private final ScoresArchive scoresArchive;
    private List<Category> categories = Arrays.asList(Ones, Twos, Threes);

    public Yatzy(DieRoller dieRoller, Notifier notifier, InputReader inputReader, ScoresArchive scoresArchive) {
        this.notifier = notifier;
        this.diceRoller = new DiceRoller(dieRoller);
        this.diceReruns = new DiceReruns(NUMBER_OF_RERUNS, diceRoller, notifier, inputReader);
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
        for(Category category : categories) {
            notifier.notifyCategory(category);
            Dice dice = diceRoller.rollAll();
            notifier.notifyCurrentDice(dice);
            dice = diceReruns.doReRuns(dice);
            int score = category.scoreFor(dice);
            notifier.notifyCategoryScore(category, score);
            scoresArchive.register(category, score);
        }
    }

}
