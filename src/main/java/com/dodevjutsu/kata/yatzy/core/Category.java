package com.dodevjutsu.kata.yatzy.core;

import static com.dodevjutsu.kata.yatzy.core.Side.*;

public enum Category {
    Ones {
        @Override
        public Score scoreFor(Dice dice) {
            return new Score(this, dice.countWithSide(S1));
        }
    },
    Twos {
        @Override
        public Score scoreFor(Dice dice) {
            return new Score(this, dice.countWithSide(S2));
        }
    },
    Threes {
        @Override
        public Score scoreFor(Dice dice) {
            return new Score(this, dice.countWithSide(S3));
        }
    };

    @Override
    public String toString() {
        return "Category: " + this.name();
    }

    abstract public Score scoreFor(Dice dice);
}
