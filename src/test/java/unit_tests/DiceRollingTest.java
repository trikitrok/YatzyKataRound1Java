package unit_tests;

import com.dodevjutsu.kata.yatzy.core.Dice;
import com.dodevjutsu.kata.yatzy.core.DieRoller;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.dodevjutsu.kata.yatzy.core.Side.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static test_helpers.Factories.dice;

public class DiceRollingTest {
    Mockery context = new Mockery();

    @Test
    public void rolling_all_dice() {
        DieRoller dieRoller = context.mock(DieRoller.class);
        context.checking(new Expectations() {{
            exactly(5).of(dieRoller).roll();
            will(onConsecutiveCalls(
                returnValue(S2),
                returnValue(S3),
                returnValue(S5),
                returnValue(S6),
                returnValue(S1)));
        }});

        Dice dice = Dice.rollAll(dieRoller);

        assertThat(dice, is(dice(S2, S3, S5, S6, S1)));
    }

    @Test
    public void rolling_given_dice() {
        DieRoller dieRoller = context.mock(DieRoller.class);
        Dice dice = dice(S1, S1, S1, S1, S1);
        context.checking(new Expectations() {{
            exactly(3).of(dieRoller).roll();
            will(onConsecutiveCalls(
                returnValue(S2),
                returnValue(S2),
                returnValue(S2)));
        }});

        dice = dice.roll(Arrays.asList(0, 2, 4), dieRoller);

        assertThat(dice, is(dice(S2, S1, S2, S1, S2)));
    }
}
