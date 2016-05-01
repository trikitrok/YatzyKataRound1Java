package unit_tests;

import com.dodevjutsu.kata.yatzy.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.dodevjutsu.kata.yatzy.Category.*;
import static com.dodevjutsu.kata.yatzy.Side.*;
import static com.dodevjutsu.kata.yatzy.Side.S1;

public class ConsoleNotifierTest {
    Mockery context;
    Console console;
    ConsoleNotifier consoleNotifier;

    @Before
    public void setup() {
        context = new Mockery();
        console = context.mock(Console.class);
        consoleNotifier = new ConsoleNotifier(console);
    }

    @Test
    public void notifies_current_category() {
        context.checking(new Expectations() {{
            oneOf(console).print("Category: Ones");
        }});

        consoleNotifier.notifyCategory(Ones);

        context.assertIsSatisfied();
    }

    @Test
    public void notifies_current_dice() {
        Dice dice = new Dice(Arrays.asList(S2, S4, S1, S6, S1));
        context.checking(new Expectations() {{
            oneOf(console).print("Dice: D1:2 D2:4 D3:1 D4:6 D5:1");
        }});

        consoleNotifier.notifyCurrentDice(dice);

        context.assertIsSatisfied();
    }

    @Test
    public void asks_user_to_input_dice_to_reroll() {
        DiceRoller notNeededDiceRoller = null;
        Notifier notNeededNotifierr = null;
        InputReader notNeededInputReader = null;
        final int NUM_RERUNS_SO_FAR = 1;
        DiceRerun diceRerun = new DiceRerun(
            NUM_RERUNS_SO_FAR, notNeededDiceRoller, notNeededNotifierr, notNeededInputReader
        );
        context.checking(new Expectations() {{
            oneOf(console).print("[1] Dice to re-run:");
        }});

        consoleNotifier.askForDiceToRerun(diceRerun);

        context.assertIsSatisfied();
    }

    @Test
    public void notifies_user_input() {
        String anyArbitraryInput = "anything";
        context.checking(new Expectations() {{
            oneOf(console).print(anyArbitraryInput);
        }});

        consoleNotifier.notifyUserInput(anyArbitraryInput);

        context.assertIsSatisfied();
    }
}
