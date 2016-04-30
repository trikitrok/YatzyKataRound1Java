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
        UserInput userInput = context.mock(UserInput.class);

        Yatzy yatzy = new Yatzy(console, userInput, dieRoller, new ConsoleNotifier(console));

        context.checking(new Expectations() {{
            oneOf(userInput).read();
            will(onConsecutiveCalls(returnValue("D1 D2 D4")));
            atLeast(1).of(dieRoller).roll();
            will(onConsecutiveCalls(
                returnValue(S2), returnValue(S4), returnValue(S1), returnValue(S6), returnValue(S1),
                returnValue(S1), returnValue(S5), returnValue(S2)));
            oneOf(console).print("Category: Ones");
            oneOf(console).print("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
            oneOf(console).print("[1] Dice to re-run:");
            oneOf(console).print("D1 D2 D4");
            oneOf(console).print("Dice: D1:1 D2:5 D3:1 D4:2 D5:1");
        }});

        yatzy.play();

        context.assertIsSatisfied();
    }
}
