package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StrikeExtraTest {
    private StrikeExtra strikeExtra;

    @Before
    public void init() {
        strikeExtra = new StrikeExtra(new Pin(5));
    }

    @Test
    public void bowlTest() {
        assertThat(strikeExtra.bowlBall(null)).isEqualTo(strikeExtra);
    }

    @Test
    public void isFrameEndTest() {
        assertThat(strikeExtra.isFrameEnd()).isFalse();
    }

    @Test
    public void toFrameViewTest() {
        assertThat(strikeExtra.toFrameView()).isEqualTo("X5 ");
    }

    @Test
    public void getScoreTest() {
        assertThat(strikeExtra.getScore()).isEqualTo(new Score(15, 1));
    }

    @Test
    public void addScoreTest() {
        assertThat(strikeExtra.addScore(new Score(10, 1))).isEqualTo(new Score(20, 0));
    }

    @Test
    public void addScoreTest2() {
        assertThat(strikeExtra.addScore(new Score(10, 2))).isEqualTo(new Score(25, 0));
    }
}
