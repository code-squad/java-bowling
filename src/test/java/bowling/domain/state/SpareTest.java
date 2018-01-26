package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SpareTest {
    private Spare spare;

    @Before
    public void init() {
        spare = new Spare(new Pin(8), new Pin(2));
    }

    @Test
    public void bowlTest() {
        assertThat(spare.bowlBall(null)).isEqualTo(spare);
    }

    @Test
    public void isFrameEndTest() {
        assertThat(spare.isFrameEnd()).isTrue();
    }

    @Test
    public void toFrameViewTest() {
        assertThat(spare.toFrameView()).isEqualTo("8|/");
    }

    @Test
    public void getScoreTest() {
        assertThat(spare.getScore()).isEqualTo(new Score(10, 1));
    }

    @Test
    public void addScoreTest() {
        assertThat(spare.addScore(new Score(10, 1))).isEqualTo(new Score(18, 0));
    }

    @Test
    public void addScoreTest2() {
        assertThat(spare.addScore(new Score(10, 2))).isEqualTo(new Score(20, 0));
    }
}
