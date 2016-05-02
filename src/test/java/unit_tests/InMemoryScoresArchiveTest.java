package unit_tests;

import com.dodevjutsu.kata.yatzy.core.Score;
import com.dodevjutsu.kata.yatzy.core.ScoresArchive;
import com.dodevjutsu.kata.yatzy.infrastructure.scores_archives.InMemoryScoresArchive;
import org.junit.Test;

import static com.dodevjutsu.kata.yatzy.core.Category.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class InMemoryScoresArchiveTest {
    @Test
    public void registers_and_retrieves_scores_by_category() {
        ScoresArchive scoresArchive = new InMemoryScoresArchive();

        scoresArchive.register(new Score(Ones, 4));
        scoresArchive.register(new Score(Twos, 2));
        scoresArchive.register(new Score(Threes, 3));

        assertThat(scoresArchive.retrieve(Ones), is(new Score(Ones, 4)));
        assertThat(scoresArchive.retrieve(Twos), is(new Score(Twos, 2)));
        assertThat(scoresArchive.retrieve(Threes), is(new Score(Threes, 3)));
    }

    @Test
    public void computes_total_score() {
        ScoresArchive scoresArchive = new InMemoryScoresArchive();

        scoresArchive.register(new Score(Ones, 4));
        scoresArchive.register(new Score(Twos, 5));
        scoresArchive.register(new Score(Threes, 3));

        assertThat(scoresArchive.totalScore(), is(12));
    }
}
