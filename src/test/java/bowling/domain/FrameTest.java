package bowling.domain;

import org.junit.Before;
import org.junit.Test;

import static bowling.enums.FrameState.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class FrameTest {
    private Frame frame;

    @Before
    public void init() {
        frame = new Frame();
    }

    @Test
    public void frameStatusTest() {
        assertThat(frame.state()).isEqualTo(NOT_END);
    }

    @Test
    public void getFrameView() {
        assertThat(frame.getFrameView()).isEqualTo("   ");

        frame.firstBowl(new Pin(5));
        assertThat(frame.getFrameView()).isEqualTo("5  ");

        frame.secondBowl(new Pin(5));
        assertThat(frame.getFrameView()).isEqualTo("5|/");
    }

    @Test
    public void firstBowlTest() {
        frame.firstBowl(new Pin(10));
        assertThat(frame.state()).isEqualTo(STRIKE);
    }

    @Test
    public void firstBowlTest2() {
        frame.firstBowl(new Pin(7));
        assertThat(frame.state()).isEqualTo(NOT_END);
    }

    @Test(expected = IllegalArgumentException.class)
    public void secondBowl_Exception_Test() {
        frame.secondBowl(new Pin(4));
    }

    @Test(expected = IllegalArgumentException.class)
    public void secondBowl_Exception_Test2() {
        frame.firstBowl(new Pin(6));
        frame.secondBowl(new Pin(5));
    }

    @Test
    public void secondBowlTest() {
        frame.firstBowl(new Pin(5));
        assertThat(frame.state()).isEqualTo(NOT_END);
        frame.secondBowl(new Pin(5));
        assertThat(frame.state()).isEqualTo(SPARE);
    }

    @Test
    public void rollBowlingBallTest() {
        frame.rollBowlingBall(new Pin(5));
        assertThat(frame.state()).isEqualTo(NOT_END);
        frame.rollBowlingBall(new Pin(5));
        assertThat(frame.state()).isEqualTo(SPARE);
    }

    @Test
    public void isFrameEndTest() {
        assertThat(frame.isFrameEnd()).isFalse();
        frame.rollBowlingBall(new Pin(10));
        assertThat(frame.isFrameEnd()).isTrue();
    }
}
