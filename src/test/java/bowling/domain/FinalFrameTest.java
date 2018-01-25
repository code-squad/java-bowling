package bowling.domain;

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

        finalFrame.rollBowlingBall(new Pin(10));
        assertThat(finalFrame.isFrameEnd()).isFalse();

        finalFrame.rollBowlingBall(new Pin(2));
        assertThat(finalFrame.isFrameEnd()).isFalse();

        finalFrame.rollBowlingBall(new Pin(7));
        assertThat(finalFrame.isFrameEnd()).isTrue();
    }

    @Test
    public void isFrameEndTest2() {
        assertThat(finalFrame.isFrameEnd()).isFalse();

        finalFrame.rollBowlingBall(new Pin(0));
        assertThat(finalFrame.isFrameEnd()).isFalse();

        finalFrame.rollBowlingBall(new Pin(5));
        assertThat(finalFrame.isFrameEnd()).isTrue();
    }

    @Test
    public void isFrameEndTest3() {
        assertThat(finalFrame.isFrameEnd()).isFalse();

        finalFrame.rollBowlingBall(new Pin(5));
        assertThat(finalFrame.isFrameEnd()).isFalse();

        finalFrame.rollBowlingBall(new Pin(5));
        assertThat(finalFrame.isFrameEnd()).isFalse();

        finalFrame.rollBowlingBall(new Pin(7));
        assertThat(finalFrame.isFrameEnd()).isTrue();
    }

    @Test(expected = IllegalArgumentException.class)
    public void invalidInputTest() {
        finalFrame.rollBowlingBall(new Pin(10));
        finalFrame.rollBowlingBall(new Pin(5));
        finalFrame.rollBowlingBall(new Pin(7));
        assertThat(finalFrame.isFrameEnd()).isTrue();
    }

    @Test
    public void invalidInputTest2() {
        finalFrame.rollBowlingBall(new Pin(10));
        finalFrame.rollBowlingBall(new Pin(10));
        finalFrame.rollBowlingBall(new Pin(7));
        assertThat(finalFrame.isFrameEnd()).isTrue();
    }

    @Test
    public void getFrameScoreTest() {
        assertThat(finalFrame.getFrameScore()).isEqualTo(null);

        finalFrame.rollBowlingBall(new Pin(10));
        finalFrame.rollBowlingBall(new Pin(10));
        finalFrame.rollBowlingBall(new Pin(10));
        assertThat(finalFrame.getFrameScore()).isEqualTo(30);

        finalFrame = new FinalFrame();
        finalFrame.rollBowlingBall(new Pin(0));
        finalFrame.rollBowlingBall(new Pin(8));
        assertThat(finalFrame.getFrameScore()).isEqualTo(8);

        finalFrame = new FinalFrame();
        finalFrame.rollBowlingBall(new Pin(2));
        finalFrame.rollBowlingBall(new Pin(8));
        finalFrame.rollBowlingBall(new Pin(8));
        assertThat(finalFrame.getFrameScore()).isEqualTo(18);
    }

    @Test
    public void calculateStrikeTest() {
        finalFrame.rollBowlingBall(new Pin(2));
        finalFrame.rollBowlingBall(new Pin(8));
        assertThat(finalFrame.calculateStrike()).isEqualTo(20);
    }

    @Test
    public void calculateSpareTest() {
        finalFrame.rollBowlingBall(new Pin(2));
        assertThat(finalFrame.calculateSpare()).isEqualTo(12);
    }
}
