package unit_tests;

import com.dodevjutsu.kata.yatzy.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import java.util.Arrays;

import static com.dodevjutsu.kata.yatzy.Category.*;
import static com.dodevjutsu.kata.yatzy.Side.*;
import static com.dodevjutsu.kata.yatzy.Side.S1;

public class ConsoleNotifierTest {

    Mockery context = new Mockery();

    @Test
    public void notifies_current_category() {
        Console console = context.mock(Console.class);
        ConsoleNotifier consoleNotifier = new ConsoleNotifier(console);
        context.checking(new Expectations() {{
            oneOf(console).print("Category: Ones");
        }});

        consoleNotifier.notifyCategory(Ones);

        context.assertIsSatisfied();
    }

    @Test
    public void notifies_current_dice() {
        Console console = context.mock(Console.class);
        ConsoleNotifier consoleNotifier = new ConsoleNotifier(console);
        Dice dice = new Dice(Arrays.asList(S2, S4, S1, S6, S1));
        context.checking(new Expectations() {{
            oneOf(console).print("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
        }});

        consoleNotifier.notifyCurrentDice(dice);

        context.assertIsSatisfied();
    }
}
