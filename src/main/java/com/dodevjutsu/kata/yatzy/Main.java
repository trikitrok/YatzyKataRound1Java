package com.dodevjutsu.kata.yatzy;

import com.dodevjutsu.kata.yatzy.application.Yatzy;
import com.dodevjutsu.kata.yatzy.infrastructure.Console;
import com.dodevjutsu.kata.yatzy.infrastructure.consoles.SystemConsole;
import com.dodevjutsu.kata.yatzy.infrastructure.die_rollers.RandomDieRoller;
import com.dodevjutsu.kata.yatzy.infrastructure.input_readers.ConsoleInputReader;
import com.dodevjutsu.kata.yatzy.infrastructure.notifiers.ConsoleNotifier;
import com.dodevjutsu.kata.yatzy.infrastructure.scores_archives.InMemoryScoresArchive;

public class Main {
    public static void main(String[] args) {
        Console console = new SystemConsole();
        ConsoleNotifier consoleNotifier = new ConsoleNotifier(console);

        Yatzy yatzy = new Yatzy(
            new RandomDieRoller(),
            new ConsoleNotifier(console),
            new ConsoleInputReader(console, consoleNotifier),
            new InMemoryScoresArchive()
        );

        yatzy.play();
    }
}
