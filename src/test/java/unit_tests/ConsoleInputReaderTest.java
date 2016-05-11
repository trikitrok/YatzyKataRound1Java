package unit_tests;

import com.dodevjutsu.kata.yatzy.core.Notifier;
import com.dodevjutsu.kata.yatzy.infrastructure.Console;
import com.dodevjutsu.kata.yatzy.infrastructure.input_readers.ConsoleInputReader;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class ConsoleInputReaderTest {
    @Test
    public void reads_dice_to_reroll() {
        Mockery context = new Mockery();
        Console console = context.mock(Console.class);
        Notifier notifier = context.mock(Notifier.class);
        ConsoleInputReader consoleInputReader = new ConsoleInputReader(console, notifier);

        context.checking(new Expectations() {{
            ignoring(notifier);
            atLeast(1).of(console).readLine();
            will(onConsecutiveCalls(returnValue("D1 D2 D4")));
        }});

        assertThat(consoleInputReader.diceToRerun("anything"), is(Arrays.asList(0, 1, 3)));
    }

    @Test
    public void asks_the_user_to_input_which_dice_to_rerun() {
        Mockery context = new Mockery();
        Console console = context.mock(Console.class);
        Notifier notifier = context.mock(Notifier.class);
        ConsoleInputReader consoleInputReader = new ConsoleInputReader(console, notifier);

        context.checking(new Expectations() {{
            ignoring(console);
            oneOf(notifier).askForDiceToRerun("anything");
        }});

        consoleInputReader.diceToRerun("anything");

        context.assertIsSatisfied();
    }

    @Test
    public void retries_when_input_is_wrong() {
        Mockery context = new Mockery();
        Console console = context.mock(Console.class);
        Notifier notifier = context.mock(Notifier.class);
        ConsoleInputReader consoleInputReader = new ConsoleInputReader(console, notifier);

        context.checking(new Expectations() {{
            atLeast(2).of(console).readLine();
            will(onConsecutiveCalls(
                returnValue("wrong input"),
                returnValue("D5 D3 D1")
            ));
            oneOf(notifier).notifyInputError(with(containsString("wrong input")));
            exactly(2).of(notifier).askForDiceToRerun("anything");
        }});

        assertThat(consoleInputReader.diceToRerun("anything"), is(Arrays.asList(4, 2, 0)));
    }
}
