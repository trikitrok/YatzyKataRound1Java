package com.dodevjutsu.kata.yatzy;

public enum Side {
    S1, S2, S3, S4, S5, S6;

    @Override
    public String toString() {
        return this.name().substring(1);
    }
}
