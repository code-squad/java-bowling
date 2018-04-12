import bowling.domain.NomalFrame;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class FrameTest {

    private NomalFrame frame;

    @Before
    public void setup() {
        frame = new NomalFrame();
    }

    @Test
    public void isTwiceBallTest() {
        frame.playOneBall(5);
        frame.playOneBall(3);
        assertThat(frame.isTwiceBall(), is(true));
    }

    @Test
    public void isNotTwiceBallTest() {
        frame.playOneBall(10);
        assertThat(frame.isTwiceBall(), is(false));
    }

    @Test
    public void isNewFrameTest() {
        assertThat(frame.isNewFrame(), is(true));
    }

    @Test
    public void isNotNewFrameTest() {
        frame.playOneBall(1);
        assertThat(frame.isNewFrame(), is(false));
    }

    @Test(expected = IllegalArgumentException.class)
    public void secondPinCheckExceptionTest() {
        frame.playOneBall(2);
        frame.playOneBall(9);
    }

    @Test(expected = IllegalArgumentException.class)
    public void frameCheckExceptionTest() {
        frame.playOneBall(2);
        frame.playOneBall(4);
        frame.playOneBall(3);
    }
}