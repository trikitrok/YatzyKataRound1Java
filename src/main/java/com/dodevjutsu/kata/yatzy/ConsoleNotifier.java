package com.dodevjutsu.kata.yatzy;

public class ConsoleNotifier {
    private final Console console;

    public ConsoleNotifier(Console console) {
        this.console = console;
    }

    public void notifyCategory(Category category) {
        console.print(category.toString());
    }
}
