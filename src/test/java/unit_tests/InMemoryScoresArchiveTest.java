package unit_tests;

import com.dodevjutsu.kata.yatzy.infrastructure.scores_archives.InMemoryScoresArchive;
import com.dodevjutsu.kata.yatzy.core.ScoresArchive;
import org.junit.Test;

import static com.dodevjutsu.kata.yatzy.core.Category.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class InMemoryScoresArchiveTest {
    @Test
    public void registers_and_retrieves_scores_by_category() {
        ScoresArchive scoresArchive = new InMemoryScoresArchive();

        scoresArchive.register(Ones, 4);
        scoresArchive.register(Twos, 2);
        scoresArchive.register(Threes, 3);

        assertThat(scoresArchive.retrieve(Ones), is(4));
        assertThat(scoresArchive.retrieve(Twos), is(2));
        assertThat(scoresArchive.retrieve(Threes), is(3));
    }

    @Test
    public void computes_total_score() {
        ScoresArchive scoresArchive = new InMemoryScoresArchive();

        scoresArchive.register(Ones, 4);
        scoresArchive.register(Twos, 5);
        scoresArchive.register(Threes, 3);

        assertThat(scoresArchive.totalScore(), is(12));
    }
}
