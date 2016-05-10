package com.dodevjutsu.kata.yatzy.infrastructure.input_readers;

public class WrongInputException extends RuntimeException {
    public WrongInputException(String m) {
        super("Invalid input: " + m);
    }
}
