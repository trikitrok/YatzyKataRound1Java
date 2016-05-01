package com.dodevjutsu.kata.yatzy;

public enum Category {
    Ones, Twos;

    @Override
    public String toString() {
        return "Category: " + this.name();
    }
}
