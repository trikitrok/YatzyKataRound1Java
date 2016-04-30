package unit_tests;

import com.dodevjutsu.kata.yatzy.InputLine;
import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class InputLineTest {
    @Test
    public void extracts_dice_to_reroll_from_input() {
        assertThat(new InputLine("D2 D3 D4").extractDiceNumbers(), is(Arrays.asList(1, 2, 3)));
        assertThat(new InputLine("D1 D3 D5").extractDiceNumbers(), is(Arrays.asList(0, 2, 4)));
    }
}
