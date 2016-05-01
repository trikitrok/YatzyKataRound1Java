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
    };

    @Override
    public String toString() {
        return "Category: " + this.name();
    }

    abstract public int scoreFor(Dice dice);
}
