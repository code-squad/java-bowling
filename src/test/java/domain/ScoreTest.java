package domain;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class ScoreTest {
    @Test
    public void generate() {
        Score myScore = new Score(10, 2);
    }

    @Test
    public void throwing() {
        Score myScore = new Score(10, 2);
        Score renewScore = myScore.bowl(new Pins(10));
        assertThat(1, is(renewScore.getLeft()));
    }

    @Test
    public void generateSpareScore() {
        Score spare = Score.ofSpare();
        assertThat(10, is(spare.getScore()));
        assertThat(1, is(spare.getLeft()));
    }
}
