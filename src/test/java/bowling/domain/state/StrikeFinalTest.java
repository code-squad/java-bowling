package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class StrikeFinalTest {
    private StrikeFinal strikeFinal;

    @Before
    public void init() {
        strikeFinal = new StrikeFinal(new Pin(5), new Pin(5));
    }

    @Test
    public void bowlTest() {
        assertThat(strikeFinal.bowlBall(null)).isEqualTo(strikeFinal);
    }

    @Test
    public void isFrameEndTest() {
        assertThat(strikeFinal.isFrameEnd()).isTrue();
    }

    @Test
    public void toFrameViewTest() {
        assertThat(strikeFinal.toFrameView()).isEqualTo("X5/");
    }

    @Test
    public void getScoreTest() {
        assertThat(strikeFinal.getScore()).isEqualTo(new Score(20, 0));
    }

    @Test
    public void addScoreTest() {
        assertThat(strikeFinal.addScore(new Score(10, 1))).isEqualTo(new Score(20, 0));
    }

    @Test
    public void addScoreTest2() {
        assertThat(strikeFinal.addScore(new Score(10, 2))).isEqualTo(new Score(25, 0));
    }
}
