package unit_tests;

import com.dodevjutsu.kata.yatzy.infrastructure.input_readers.InputLine;
import com.dodevjutsu.kata.yatzy.infrastructure.input_readers.WrongInputException;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

public class InputLineTest {
    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @Test
    public void extracts_dice_from_input() {
        assertThat(new InputLine("D2 D3 D4").extractDiceIndexes(), is(Arrays.asList(1, 2, 3)));
        assertThat(new InputLine("D1 D3 D5").extractDiceIndexes(), is(Arrays.asList(0, 2, 4)));
    }

    @Test
    public void extracts_dice_from_empty_input() {
        assertThat(new InputLine("").extractDiceIndexes(), is(Collections.emptyList()));
    }

    @Test
    public void throws_when_input_is_wrong() throws WrongInputException {
        List<String> invalidInputs = Arrays.asList("D1 3 D5", "a1 x1 D1", "ñ");
        for(String invalidInput : invalidInputs) {
            thrown.expect(WrongInputException.class);
            thrown.expectMessage(containsString(invalidInput));
            new InputLine(invalidInput).extractDiceIndexes();
        }
    }
}
