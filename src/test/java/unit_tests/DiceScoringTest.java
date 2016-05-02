package unit_tests;

import com.dodevjutsu.kata.yatzy.core.Dice;
import com.dodevjutsu.kata.yatzy.core.Score;
import org.junit.Test;

import java.util.Arrays;

import static com.dodevjutsu.kata.yatzy.core.Category.Ones;
import static com.dodevjutsu.kata.yatzy.core.Category.Twos;
import static com.dodevjutsu.kata.yatzy.core.Side.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class DiceScoringTest {
    @Test
    public void computes_score_for_Ones_category() {
        assertThat(Ones.scoreFor(new Dice(Arrays.asList(S1, S2, S3, S4, S5))), is(new Score(Ones, 1)));
        assertThat(Ones.scoreFor(new Dice(Arrays.asList(S1, S2, S1, S4, S5))), is(new Score(Ones, 2)));
    }


    @Test
    public void computes_score_for_Twos_category() {
        assertThat(Twos.scoreFor(new Dice(Arrays.asList(S1, S2, S3, S4, S5))), is(new Score(Twos, 1)));
        assertThat(Twos.scoreFor(new Dice(Arrays.asList(S2, S2, S1, S2, S5))), is(new Score(Twos, 3)));
    }
}
