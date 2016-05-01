package unit_tests;

import com.dodevjutsu.kata.yatzy.core.Dice;
import com.dodevjutsu.kata.yatzy.core.DiceRoller;
import com.dodevjutsu.kata.yatzy.infrastructure.DieRoller;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static com.dodevjutsu.kata.yatzy.core.Side.S1;
import static com.dodevjutsu.kata.yatzy.core.Side.S2;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class DiceRollerTest {
    Mockery context = new Mockery();

    @Test
    public void rolling_give_dice() {
        DieRoller dieRoller = context.mock(DieRoller.class);
        DiceRoller diceRoller = new DiceRoller(dieRoller);
        List<Integer> diceToRerollIndexes = Arrays.asList(0, 2, 4);
        Dice dice = new Dice(Arrays.asList(S1, S1, S1, S1, S1));
        context.checking(new Expectations() {{
            exactly(3).of(dieRoller).roll();
            will(onConsecutiveCalls(
                returnValue(S2),
                returnValue(S2),
                returnValue(S2)));
        }});

        dice = diceRoller.roll(dice, diceToRerollIndexes);

        assertThat(dice, is(new Dice(Arrays.asList(S2, S1, S2, S1, S2))));
    }
}
