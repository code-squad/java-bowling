package bowling.domain.state;

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
        assertThat(strike.bowlBall(null)).isEqualTo(strike);
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
}
