package com.dodevjutsu.kata.yatzy.core;

public enum Category {
    Ones {
        @Override
        public int scoreFor(Dice dice) {
            return dice.countWithSide(Side.S1);
        }
    },
    Twos {
        @Override
        public int scoreFor(Dice dice) {
            return dice.countWithSide(Side.S2);
        }
    },
    Threes {
        @Override
        public int scoreFor(Dice dice) {
            return dice.countWithSide(Side.S3);
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
