package bowling.domain;

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
        frames.rollBowlingBall(new CurrentInfo("KKH", 0), new Pin(10));
        assertThat(frames.printFrames()).isEqualTo(
                "  X   |      |      |      |      |      |      |      |      |      |"
        );
    }
}
