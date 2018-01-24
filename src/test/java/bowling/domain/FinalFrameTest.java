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
}
