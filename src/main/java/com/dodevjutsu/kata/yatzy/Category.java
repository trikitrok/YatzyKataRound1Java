package com.dodevjutsu.kata.yatzy;

import static com.dodevjutsu.kata.yatzy.Side.*;

public enum Category {
    Ones {
        @Override
        public int scoreFor(Dice dice) {
            return dice.countWithSide(S1);
        }
    },
    Twos {
        @Override
        public int scoreFor(Dice dice) {
            return dice.countWithSide(S2);
        }
    },
    Threes {
        @Override
        public int scoreFor(Dice dice) {
            return dice.countWithSide(S3);
        }
    };

    @Override
    public String toString() {
        return "Category: " + this.name();
    }

    abstract public int scoreFor(Dice dice);

    public String scoreAsString(int score) {
        return "Category " + this.name() + " score: " + score;
    }
}
