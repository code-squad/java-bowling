package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;

import static bowling.enums.FrameState.*;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

public class FramesTest {
    private Frames frames;

    @Before
    public void init() {
        frames = new Frames();
    }

    @Test
    public void rollBowlingBallTest() {
        frames.rollBowlingBall(0, new Pin(10));
        assertThat(frames.getState(0)).isEqualTo(STRIKE);
    }

    @Test
    public void getStateTest() {
        assertThat(frames.getState(0)).isEqualTo(NOT_END);
    }

    @Test
    public void isCurrentFrameEndTest() {
        assertThat(frames.isCurrentFrameEnd(0)).isFalse();
        frames.rollBowlingBall(0, new Pin(10));
        assertThat(frames.isCurrentFrameEnd(0)).isTrue();
    }

    @Test
    public void getFrameViewsTest() {
        frames.rollBowlingBall(0, new Pin(10));
        frames.rollBowlingBall(1, new Pin(10));
        frames.rollBowlingBall(2, new Pin(10));
        frames.rollBowlingBall(3, new Pin(10));

        assertThat(frames.getFrameViews()).isEqualTo(Arrays.asList(
                "X  ", "X  ", "X  ", "X  ", "   ",
                "   ", "   ", "   ", "   ", "   "
        ));
    }

    @Test
    public void getScoreViewsTest() {
        frames.rollBowlingBall(0, new Pin(10));
        frames.rollBowlingBall(1, new Pin(10));
        frames.rollBowlingBall(2, new Pin(10));
        frames.rollBowlingBall(3, new Pin(10));

        assertThat(frames.getScoreViews()).isEqualTo(Arrays.asList(
                "30 ", "60 ", "   ", "   ", "   ",
                "   ", "   ", "   ", "   ", "   "
        ));
    }
}
