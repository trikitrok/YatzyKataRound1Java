package unit_tests;

import com.dodevjutsu.kata.yatzy.Console;
import com.dodevjutsu.kata.yatzy.ConsoleInputReader;
import com.dodevjutsu.kata.yatzy.Dice;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class ConsoleUserInputReaderTest {
    @Test
    public void reads_dice_to_reroll() {
        Mockery context = new Mockery();
        Console console = context.mock(Console.class);
        ConsoleInputReader consoleInputReader = new ConsoleInputReader(console);

        context.checking(new Expectations() {{
            atLeast(1).of(console).readLine();
            will(onConsecutiveCalls(returnValue("D1 D2 D4")));
            oneOf(console).print("D1 D2 D4");
        }});

        assertThat(consoleInputReader.diceToReroll(), is(Arrays.asList(0, 1, 3)));
    }
}