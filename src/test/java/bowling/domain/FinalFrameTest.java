package bowling.domain;

import bowling.exception.CannotCalculateException;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FinalFrameTest {
    private FinalFrame finalFrame;

    @Before
    public void init() {
        finalFrame = new FinalFrame();
    }

    @Test
    public void isFrameEndTest() {
        assertThat(finalFrame.isFrameEnd()).isFalse();

        finalFrame.rollBowlingBall(0);
        assertThat(finalFrame.isFrameEnd()).isFalse();

        finalFrame.rollBowlingBall(3);
        assertThat(finalFrame.isFrameEnd()).isTrue();
    }

    @Test
    public void isFrameEndTest2() {
        assertThat(finalFrame.isFrameEnd()).isFalse();

        finalFrame.rollBowlingBall(0);
        assertThat(finalFrame.isFrameEnd()).isFalse();

        finalFrame.rollBowlingBall(5);
        assertThat(finalFrame.isFrameEnd()).isTrue();
    }

    @Test
    public void isFrameEndTest3() {
        assertThat(finalFrame.isFrameEnd()).isFalse();

        finalFrame.rollBowlingBall(5);
        assertThat(finalFrame.isFrameEnd()).isFalse();

        finalFrame.rollBowlingBall(5);
        assertThat(finalFrame.isFrameEnd()).isFalse();

        finalFrame.rollBowlingBall(7);
        assertThat(finalFrame.isFrameEnd()).isTrue();
    }

    @Test(expected = CannotCalculateException.class)
    public void getFrameScoreTest() {
        assertThat(finalFrame.getScore()).isEqualTo(null);
    }

    @Test
    public void getFrameScoreTest2() {
        finalFrame.rollBowlingBall(10);
        finalFrame.rollBowlingBall(10);
        finalFrame.rollBowlingBall(10);
        assertThat(finalFrame.getScore()).isEqualTo(30);

        finalFrame = new FinalFrame();
        finalFrame.rollBowlingBall(0);
        finalFrame.rollBowlingBall(8);
        assertThat(finalFrame.getScore()).isEqualTo(8);

        finalFrame = new FinalFrame();
        finalFrame.rollBowlingBall(2);
        finalFrame.rollBowlingBall(8);
        finalFrame.rollBowlingBall(8);
        assertThat(finalFrame.getScore()).isEqualTo(18);
    }

    @Test
    public void calculateAdditionalScoreTest() {
        finalFrame.rollBowlingBall(5);
        finalFrame.rollBowlingBall(5);
        assertThat(finalFrame.calculateAdditionalScore(new Score(10, 2)))
                .isEqualTo(20);
    }
}
