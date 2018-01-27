package bowling.domain.state;

import bowling.domain.Pin;
import bowling.domain.Score;
import bowling.exception.CannotCalculateException;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FirstBowlTest {
    private FirstBowl firstBowl;

    @Before
    public void init() {
        firstBowl = new FirstBowl(new Pin(5));
    }

    @Test
    public void bowlTest() {
        assertThat(firstBowl.bowlBall(new Pin(0))).isExactlyInstanceOf(Miss.class);
        assertThat(firstBowl.bowlBall(new Pin(5))).isExactlyInstanceOf(Spare.class);
    }

    @Test
    public void isFrameEndTest() {
        assertThat(firstBowl.isFrameEnd()).isFalse();
    }

    @Test
    public void toFrameViewTest() {
        assertThat(firstBowl.toFrameView()).isEqualTo("5  ");
    }

    @Test(expected = CannotCalculateException.class)
    public void getScoreTest() {
        firstBowl.getScore();
    }

    @Test
    public void addScoreTest() {
        assertThat(firstBowl.addScore(new Score(10, 1))).isEqualTo(new Score(15, 0));
    }
}
