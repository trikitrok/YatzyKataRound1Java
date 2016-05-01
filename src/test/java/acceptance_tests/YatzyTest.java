package acceptance_tests;

import com.dodevjutsu.kata.yatzy.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import static com.dodevjutsu.kata.yatzy.Side.*;

public class YatzyTest {

    Mockery context = new Mockery();

    @Test
    public void game_console_output() {
        Console console = context.mock(Console.class);
        DieRoller dieRoller = context.mock(DieRoller.class);
        ConsoleNotifier consoleNotifier = new ConsoleNotifier(console);

        Yatzy yatzy = new Yatzy(
            dieRoller,
            consoleNotifier,
            new ConsoleInputReader(console, consoleNotifier)
        );

        context.checking(new Expectations() {{
            atLeast(1).of(console).readLine();
            will(onConsecutiveCalls(
                returnValue("D1 D2 D4"),
                returnValue("D2 D4"),
                returnValue("D1 D2 D3"),
                returnValue("D2 D3"),
                returnValue("D1 D4 D5"),
                returnValue("D1 D4 D5")
            ));
            atLeast(1).of(dieRoller).roll();
            will(onConsecutiveCalls(
                returnValue(S2), returnValue(S4), returnValue(S1), returnValue(S6), returnValue(S1),
                returnValue(S1), returnValue(S5), returnValue(S2),
                returnValue(S1), returnValue(S5),
                returnValue(S3), returnValue(S5), returnValue(S6), returnValue(S2), returnValue(S2),
                returnValue(S2), returnValue(S4), returnValue(S3),
                returnValue(S5), returnValue(S2),
                returnValue(S4), returnValue(S3), returnValue(S3), returnValue(S5), returnValue(S6),
                returnValue(S6), returnValue(S2), returnValue(S1),
                returnValue(S3), returnValue(S5), returnValue(S4)
            ));
            oneOf(console).print("Category: Ones");
            oneOf(console).print("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
            oneOf(console).print("[1] Dice to re-run:");
            oneOf(console).print("D1 D2 D4");
            oneOf(console).print("Dice: D1:1 D2:5 D3:1 D4:2 D5:1");
            oneOf(console).print("[2] Dice to re-run:");
            oneOf(console).print("D2 D4");
            oneOf(console).print("Dice: D1:1 D2:1 D3:1 D4:5 D5:1");
            oneOf(console).print("Category Ones score: 4");

            oneOf(console).print("Category: Twos");
            oneOf(console).print("Dice: D1:3 D2:5 D3:6 D4:2 D5:2");
            oneOf(console).print("[1] Dice to re-run:");
            oneOf(console).print("D1 D2 D3");
            oneOf(console).print("Dice: D1:2 D2:4 D3:3 D4:2 D5:2");
            oneOf(console).print("[2] Dice to re-run:");
            oneOf(console).print("D2 D3");
            oneOf(console).print("Dice: D1:2 D2:5 D3:2 D4:2 D5:2");
            oneOf(console).print("Category Twos score: 4");

            oneOf(console).print("Category: Threes");
            oneOf(console).print("Dice: D1:4 D2:3 D3:3 D4:5 D5:6");
            oneOf(console).print("[1] Dice to re-run:");
            oneOf(console).print("D1 D4 D5");
            oneOf(console).print("Dice: D1:6 D2:3 D3:3 D4:2 D5:1");
            oneOf(console).print("[2] Dice to re-run:");
            oneOf(console).print("D1 D4 D5");
            oneOf(console).print("Dice: D1:3 D2:3 D3:3 D4:5 D5:4");
            oneOf(console).print("Category Threes score: 3");
        }});

        yatzy.play();

        context.assertIsSatisfied();
    }
}
