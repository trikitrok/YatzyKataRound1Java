package unit_tests;

import com.dodevjutsu.kata.yatzy.core.*;
import com.dodevjutsu.kata.yatzy.infrastructure.Console;
import com.dodevjutsu.kata.yatzy.infrastructure.notifiers.ConsoleNotifier;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.dodevjutsu.kata.yatzy.core.Category.*;
import static com.dodevjutsu.kata.yatzy.core.Side.*;

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
        DieRoller notNeededDieRoller = null;
        Notifier notNeededNotifier = null;
        InputReader notNeededInputReader = null;
        final int NUM_RERUNS_SO_FAR = 1;
        DiceRerun diceRerun = new DiceRerun(
            NUM_RERUNS_SO_FAR, notNeededDieRoller, notNeededNotifier, notNeededInputReader
        );
        context.checking(new Expectations() {{
            oneOf(console).print("[1] Dice to re-run:");
        }});

        consoleNotifier.askForDiceToRerun(diceRerun);

        context.assertIsSatisfied();
    }

    @Test
    public void notifies_game_summary() {
        ScoresArchive scoresArchive = context.mock(ScoresArchive.class);

        context.checking(new Expectations() {{
            oneOf(scoresArchive).retrieve(Ones);
            will(returnValue(new Score(Ones, 2)));
            oneOf(scoresArchive).retrieve(Twos);
            will(returnValue(new Score(Twos,4)));
            oneOf(scoresArchive).retrieve(Threes);
            will(returnValue(new Score(Threes, 3)));
            oneOf(scoresArchive).totalScore();
            will(returnValue(9));
            oneOf(console).print("Yahtzee score");
            oneOf(console).print("Ones: 2");
            oneOf(console).print("Twos: 4");
            oneOf(console).print("Threes: 3");
            oneOf(console).print("Final score: 9");
        }});

        consoleNotifier.notifyGameSummary(new GameSummary(Arrays.asList(Ones, Twos, Threes), scoresArchive));
    }
}
