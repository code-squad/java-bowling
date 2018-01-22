package bowling.domain;

import bowling.enums.FrameStatus;
import org.junit.Before;
import org.junit.Test;

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
        assertThat(frames.printFrames()).isEqualTo(
                "  X   |      |      |      |      |      |      |      |      |      |"
        );
    }

    @Test
    public void getStateTest() {
        assertThat(frames.getState(0)).isEqualTo(FrameStatus.NOT_START);
    }

    @Test
    public void isCurrentFrameEndTest() {
        assertThat(frames.isCurrentFrameEnd(0)).isFalse();
        frames.rollBowlingBall(0, new Pin(10));
        assertThat(frames.isCurrentFrameEnd(0)).isTrue();
    }
}
