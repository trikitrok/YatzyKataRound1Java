package unit_tests;

import com.dodevjutsu.kata.yatzy.Dice;
import org.junit.Test;

import java.util.Arrays;

import static com.dodevjutsu.kata.yatzy.Category.Ones;
import static com.dodevjutsu.kata.yatzy.Side.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DiceScoringTest {
    @Test
    public void computes_score_for_Ones_category() {
        assertThat(Ones.scoreFor(new Dice(Arrays.asList(S1, S2, S3, S4, S5))), is(1));
        assertThat(Ones.scoreFor(new Dice(Arrays.asList(S1, S2, S1, S4, S5))), is(2));
    }

}
