package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StrikeTest {
    private Strike strike;

    @Before
    public void init() {
        strike = new Strike();
    }

    @Test
    public void bowlTest() {
        assertThat(strike.bowlBall(new Pin(10))).isExactlyInstanceOf(StrikeExtra.class);
    }

    @Test
    public void isFrameEndTest() {
        assertThat(strike.isFrameEnd()).isTrue();
    }

    @Test
    public void toFrameViewTest() {
        assertThat(strike.toFrameView()).isEqualTo("X  ");
    }

    @Test
    public void getScoreTest() {
        assertThat(strike.getScore()).isEqualTo(new Score(10, 2));
    }

    @Test
    public void addScoreTest() {
        assertThat(strike.addScore(new Score(10, 1))).isEqualTo(new Score(20, 0));
    }
}
