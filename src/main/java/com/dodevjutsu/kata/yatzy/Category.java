package com.dodevjutsu.kata.yatzy;

public enum Category {
    Ones;

    @Override
    public String toString() {
        return "Category: " + this.name();
    }
}
