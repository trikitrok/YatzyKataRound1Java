package unit_tests;

import com.dodevjutsu.kata.yatzy.core.*;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static com.dodevjutsu.kata.yatzy.core.Side.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static test_helpers.Factories.dice;

public class DiceRerunTest {

    Mockery context = new Mockery();
    private int rerun_number;
    private Notifier notifier;
    private InputReader inputReader;
    private DieRoller dieRoller;
    private DiceRerun diceRerun;
    private Dice initialDice;

    @Before
    public void setUp() throws Exception {
        rerun_number = 1;
        notifier = context.mock(Notifier.class);
        inputReader = context.mock(InputReader.class);
        dieRoller = context.mock(DieRoller.class);
        diceRerun = new DiceRerun(
            rerun_number, dieRoller, notifier, inputReader
        );
        initialDice = dice(S1, S1, S1, S1, S1);
    }

    @Test
    public void notifies_the_current_dice() {
        context.checking(new Expectations() {{
            atLeast(1).of(dieRoller).roll();
            will(onConsecutiveCalls(
                returnValue(S4), returnValue(S5)
            ));
            atLeast(1).of(inputReader).diceToRerun(with(any(Integer.class)));
            will(returnValue(Arrays.asList(1, 4)));

            oneOf(notifier).notifyCurrentDice(dice(S1, S4, S1, S1, S5));
        }});

        diceRerun.doRerun(initialDice);

        context.assertIsSatisfied();
    }

    @Test
    public void rolls_the_dice_to_rerun() {
        context.checking(new Expectations() {{
            atLeast(1).of(dieRoller).roll();
            will(onConsecutiveCalls(
                returnValue(S2), returnValue(S4)
            ));
            atLeast(1).of(inputReader).diceToRerun(with(any(Integer.class)));
            will(returnValue(Arrays.asList(0, 3)));
            ignoring(notifier);
        }});

        assertThat(diceRerun.doRerun(initialDice), is(dice(S2, S1, S1, S4, S1)));
    }
}
