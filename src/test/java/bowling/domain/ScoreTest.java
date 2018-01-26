package bowling.domain;

import bowling.exception.CannotCalculateException;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ScoreTest {
    private Score score;

    @Before
    public void init() {
        score = new Score(5, 1);
    }

    @Test
    public void bowlTest() {
        assertThat(score.bowl(5)).isEqualTo(new Score(10, 0));
    }

    @Test(expected = CannotCalculateException.class)
    public void getScoreTest() {
        assertThat(score.getScore()).isEqualTo(5);
    }

    @Test
    public void getScoreTest2() {
        score = score.bowl(5);
        assertThat(score.getScore()).isEqualTo(10);
    }

    @Test
    public void calculableTest() {
        assertThat(score.calculable()).isFalse();
    }
}
