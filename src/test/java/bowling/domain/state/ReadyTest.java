package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;
import bowling.exception.CannotCalculateException;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReadyTest {
    private Ready ready;

    @Before
    public void init() {
        ready = new Ready();
    }

    @Test
    public void bowlTest() {
        assertThat(ready.bowlBall(new Pin(10))).isExactlyInstanceOf(Strike.class);
        assertThat(ready.bowlBall(new Pin(5))).isExactlyInstanceOf(FirstBowl.class);
    }

    @Test
    public void isFrameEndTest() {
        assertThat(ready.isFrameEnd()).isFalse();
    }

    @Test
    public void toFrameViewTest() {
        assertThat(ready.toFrameView()).isEqualTo("   ");
    }

    @Test(expected = CannotCalculateException.class)
    public void getScoreTest() {
        ready.getScore();
    }

    @Test(expected = CannotCalculateException.class)
    public void addScoreTest2() {
        ready.addScore(new Score(10, 2));
    }
}
