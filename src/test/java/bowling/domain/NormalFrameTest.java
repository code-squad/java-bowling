package bowling.domain;

import bowling.exception.CannotCalculateException;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class NormalFrameTest {
    private NormalFrame normalFrame;

    @Before
    public void init() {
        FinalFrame finalFrame = new FinalFrame();
        finalFrame.rollBowlingBall(5);
        finalFrame.rollBowlingBall(5);

        normalFrame = new NormalFrame(finalFrame);
    }

    @Test
    public void getFrameView() {
        assertThat(normalFrame.getFrameView()).isEqualTo("   ");

        normalFrame.rollBowlingBall(5);
        assertThat(normalFrame.getFrameView()).isEqualTo("5  ");

        normalFrame.rollBowlingBall(5);
        assertThat(normalFrame.getFrameView()).isEqualTo("5|/");
    }

    @Test
    public void rollBowlingBallTest() {
        normalFrame.rollBowlingBall(5);
        assertThat(normalFrame.getFrameView()).isEqualTo("5  ");
        normalFrame.rollBowlingBall(5);
        assertThat(normalFrame.getFrameView()).isEqualTo("5|/");
    }

    @Test
    public void isFrameEndTest() {
        assertThat(normalFrame.isFrameEnd()).isFalse();
        normalFrame.rollBowlingBall(10);
        assertThat(normalFrame.isFrameEnd()).isTrue();
    }

    @Test
    public void getScoreTest() {
        normalFrame.rollBowlingBall(8);
        normalFrame.rollBowlingBall(1);
        assertThat(normalFrame.getScore()).isEqualTo(9);
    }

    @Test(expected = CannotCalculateException.class)
    public void getScoreTest2() {
        normalFrame.rollBowlingBall(8);
        normalFrame.getScore();
    }

    @Test
    public void calculateAdditionalScoreTest() {
        normalFrame.rollBowlingBall(5);
        normalFrame.rollBowlingBall(5);
        assertThat(normalFrame.calculateAdditionalScore(new Score(10, 2)))
                .isEqualTo(20);
    }

    @Test
    public void getScoreTest3() {
        normalFrame.rollBowlingBall(10);
        assertThat(normalFrame.getScore()).isEqualTo(20);
    }
}
