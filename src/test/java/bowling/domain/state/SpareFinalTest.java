package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SpareFinalTest {
    private SpareFinal spareFinal;

    @Before
    public void init() {
        spareFinal = new SpareFinal(new Pin(8), new Pin(2), new Pin(5));
    }

    @Test
    public void bowlTest() {
        assertThat(spareFinal.bowlBall(null)).isEqualTo(spareFinal);
    }

    @Test
    public void isFrameEndTest() {
        assertThat(spareFinal.isFrameEnd()).isTrue();
    }

    @Test
    public void toFrameViewTest() {
        assertThat(spareFinal.toFrameView()).isEqualTo("8/5");
    }

    @Test
    public void getScoreTest() {
        assertThat(spareFinal.getScore()).isEqualTo(new Score(15, 0));
    }

    @Test
    public void addScoreTest() {
        assertThat(spareFinal.addScore(new Score(10, 1))).isEqualTo(new Score(18, 0));
    }

    @Test
    public void addScoreTest2() {
        assertThat(spareFinal.addScore(new Score(10, 2))).isEqualTo(new Score(20, 0));
    }
}
